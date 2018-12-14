package com.llnqdx.mvnproj.fastdfs.client;

import com.alibaba.fastjson.JSON;
import com.llnqdx.mvnproj.fastdfs.model.FastDFSFile;
import com.llnqdx.mvnproj.fastdfs.model.FdfsFileInfo;
import com.llnqdx.mvnproj.utils.MD5Utils;
import com.llnqdx.mvnproj.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

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
        byte[] fileBuff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (inputStream != null) {
            int length = inputStream.available();
            fileBuff = new byte[length];
            inputStream.read(fileBuff);
        }
        inputStream.close();
        FdfsFileInfo fdfsFileTbl = new FdfsFileInfo();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        FastDFSFile fastDFSFile = new FastDFSFile(fileName, fileBuff, ext);
        fdfsFileTbl.setFileName(fileName);
        supplementFileInfo(multipartFile, fdfsFileTbl);
        logger.info("fastDFSFile Name [{}]  fastDFSFile Length [{}]", fileName, fastDFSFile.getContent().length);
        try {
            long startTime = System.currentTimeMillis();
            fileAbsolutePath = FastDFSClient.upload(fastDFSFile);  //upload to fastdfs
            Long usedTime = System.currentTimeMillis() - startTime;
            fdfsFileTbl.setUsedTime(usedTime.intValue());
            double avgUploadSpeed = BigDecimal.valueOf(fdfsFileTbl.getFileSize()).divide(BigDecimal.valueOf(fdfsFileTbl.getUsedTime()), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fdfsFileTbl.setAvgUploadSpeed(avgUploadSpeed);
            logger.info("upload_file usedTime [{}] ms avgUploadSpeed [{}]", usedTime, avgUploadSpeed);
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
            return null;
        }
        String path = fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        fdfsFileTbl.setFileUrl(path);
        logger.info("upload file fdfsFileTbl [{}]", JSON.toJSONString(fdfsFileTbl));
        return fdfsFileTbl;
    }

    private static void supplementFileInfo(MultipartFile multipartFile, FdfsFileInfo fdfsFileTbl) {
        try {
            logger.info("supplementFileInfo start");
            String fileMd5 = MD5Utils.getMD5ByInputStream(multipartFile.getInputStream());
            fdfsFileTbl.setFileMd5(fileMd5);
            fdfsFileTbl.setFileSize(multipartFile.getInputStream().available());
            String fileName = multipartFile.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            File file = File.createTempFile(prefix, String.valueOf(System.currentTimeMillis())); //create temporary files
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
            BufferedImage bufferedImage = ImageIO.read(file); //gets a stream of images from a temporary file
            if (bufferedImage != null) {
                fdfsFileTbl.setImgWidth(bufferedImage.getWidth());
                fdfsFileTbl.setImgHeight(bufferedImage.getHeight());
                logger.info("supplementFileInfo image info imgWidth [{}] imgHeight [{}]", bufferedImage.getWidth(), bufferedImage.getHeight());
            }
        } catch (Exception e) {
            logger.error("supplementFileInfo error ", e);
        }
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
     * @Description: <p>
     * group example：group1
     * storagePath example：M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * result code -1 0 2
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
