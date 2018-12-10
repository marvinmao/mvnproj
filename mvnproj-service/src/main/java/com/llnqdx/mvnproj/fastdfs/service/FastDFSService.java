package com.llnqdx.mvnproj.fastdfs.service;

import com.llnqdx.mvnproj.model.FdfsFileTbl;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: marvinmao
 * @Date: 2018/12/8
 * @Description:
 */
public interface FastDFSService {

    FdfsFileTbl saveFile(MultipartFile file);

    String deleteFile(String filePath);
}
