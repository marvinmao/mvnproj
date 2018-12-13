package com.llnqdx.mvnproj.fastdfs.service;

import com.llnqdx.mvnproj.fastdfs.model.FdfsFileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Auther: marvinmao
 * @Date: 2018/12/8
 */
public interface FastDFSService {

    FdfsFileInfo saveFile(MultipartFile file);

    String deleteFile(String filePath);

    String downloadFile(String uuid);
}
