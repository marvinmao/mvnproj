package com.llnqdx.mvnproj.fastdfs.client;

import com.alibaba.fastjson.JSON;
import com.llnqdx.mvnproj.fastdfs.model.FastDFSFile;
import com.llnqdx.mvnproj.fastdfs.model.FdfsFileInfo;
import com.llnqdx.mvnproj.utils.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Auther: marvinmao
 * @Date: 2018/12/8
 */
public class FastDFSClient {
    private static final Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    static {
        try {
            String filePath = new ClassPathResource("application-fastdfs.properties").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            logger.error("FastDFS Client Init Fail!", e);
        }
    }

    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (IOException e) {
            logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    /**
     * @Description:
     * @param: [multipartFile]
     * @return: com.llnqdx.mvnproj.model.FdfsFileTbl
     */
    public static FdfsFileInfo saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (inputStream != null) {
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FdfsFileInfo fdfsFileTbl = new FdfsFileInfo();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        fdfsFileTbl.setFileName(fileName);
        int fileLength = file.getContent().length;
        fdfsFileTbl.setFileLength(fileLength);
        logger.info("File Name [{}]  File Length [{}]", fileName, file.getContent().length);
        try {
            long startTime = System.currentTimeMillis();
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
            Long usedTime = System.currentTimeMillis() - startTime;
            fdfsFileTbl.setUsedTime(usedTime.intValue());
            logger.info("upload_file usedTime [{}] ms", usedTime);
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        String path = fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        fdfsFileTbl.setFileUrl(path);
        logger.info("upload file fdfsFileTbl [{}]", JSON.toJSONString(fdfsFileTbl));
        return fdfsFileTbl;
    }

    /**
     * @Description:
     * @param: [file]
     * @return: java.lang.String[]
     */
    public static String[] upload(FastDFSFile file) {
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        String[] uploadResults = null;
        StorageClient storageClient = null;
        try {
            storageClient = getTrackerClient();
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (IOException e) {
            logger.error("IO Exception when uploadind the file:" + file.getName(), e);
        } catch (Exception e) {
            logger.error("Non IO Exception when uploadind the file:" + file.getName(), e);
        }

        if (uploadResults == null && storageClient != null) {
            logger.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        logger.info("upload file successfully group_name [{}] remoteFileName [{}]", groupName, remoteFileName);
        return uploadResults;
    }

    /**
     * @Description:
     * <p>
     * group example：group1
     * storagePath example：M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * result code -1 0 2
     *
     * @param: [groupName, remoteFileName]
     * @return: int
     */
    public static int deleteFile(String groupName, String remoteFileName) throws Exception {
        logger.info("deleteFile start groupName [{}] remoteFileName [{}]", groupName, remoteFileName);
        if (StringUtils.isEmpty(groupName) || StringUtils.isEmpty(remoteFileName)) {
            logger.error("deleteFile error param is validate");
            return 0;
        }
        StorageClient storageClient = getTrackerClient();
        int deleteFile = storageClient.delete_file(groupName, remoteFileName);
        logger.info("deleteFile end deleteFile [{}]", deleteFile);
        return deleteFile;
    }

    public static StorageServer[] getStoreStorages(String groupName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }

    public static ServerInfo[] getFetchStorages(String groupName, String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    public static String getTrackerUrl() throws IOException {
        return "http://" + getTrackerServer().getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port() + "/";
    }

    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }

    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }
}
