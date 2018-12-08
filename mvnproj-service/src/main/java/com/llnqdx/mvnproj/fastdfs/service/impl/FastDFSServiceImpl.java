package com.llnqdx.mvnproj.fastdfs.service.impl;

import com.llnqdx.mvnproj.fastdfs.client.FastDFSClient;
import com.llnqdx.mvnproj.fastdfs.service.FastDFSService;
import com.llnqdx.mvnproj.mapper.FdfsFileTblMapper;
import com.llnqdx.mvnproj.model.FdfsFileTbl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: maofujiang
 * @Date: 2018/12/8
 * @Description:
 */
@Service(value = "FastDFSService")
public class FastDFSServiceImpl implements FastDFSService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${fastdfs_file_path_prifix}")
    private String filePrifix;

    @Autowired
    private FdfsFileTblMapper fdfsFileTblMapper;

    @Override
    public FdfsFileTbl saveFile(MultipartFile file) {
        try {
            FdfsFileTbl fdfsFileTbl = FastDFSClient.saveFile(file);
            fdfsFileTblMapper.insert(fdfsFileTbl);
            fdfsFileTbl.setFilePath(filePrifix + fdfsFileTbl.getFileUrl());
            return fdfsFileTbl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteFile(String filePath) {
        filePath = filePath.replace(filePrifix, "");
        String[] split = filePath.split("/");
        List<String> list = Arrays.asList(split);
        if (CollectionUtils.isEmpty(list)) {
            logger.error("singleFileDelete error filePath is validate");
            return null;
        }
        String groupName = list.get(0);
        String remoteFileName = filePath.replace(groupName + "/", "");
        try {
            String deleteMsg = "";
            int deleteFile = FastDFSClient.deleteFile(groupName, remoteFileName);
            if (deleteFile==0) {
//                fdfsFileTblMapper.
            }
            //-1失败,0成功 ,2找不到文件
            switch (deleteFile) {
                case -1:
                    deleteMsg = "删除失败";
                    break;
                case 0:
                    deleteMsg = "删除成功";
                    break;
                case 2:
                    deleteMsg = "找不到文件";
                    break;
                default:
                    break;
            }
            logger.info("singleFileDelete end deleteMsg [{}]", deleteMsg);
            return deleteMsg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
