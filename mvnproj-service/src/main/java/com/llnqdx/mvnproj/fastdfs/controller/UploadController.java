package com.llnqdx.mvnproj.fastdfs.controller;

import com.alibaba.fastjson.JSON;
import com.llnqdx.mvnproj.fastdfs.service.FastDFSService;
import com.llnqdx.mvnproj.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: marvinmao
 * @Date: 2018/12/8
 * @Description:
 */
@RestController
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FastDFSService fastDFSService;

    @PostMapping("/upload_file") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            logger.error("singleFileUpload error file is empty");
            return null;
        }
        try {
            return JSON.toJSONString(fastDFSService.saveFile(file));
        } catch (Exception e) {
            logger.error("singleFileUpload failed", e);
        }
        return null;
    }

    @GetMapping("/delete_file") //new annotation since 4.3
    public String singleFileDelete(@RequestParam("file_path") String filePath) {
        logger.info("singleFileDelete start filePath [{}]", filePath);
        try {
            if (StringUtils.isEmpty(filePath)) {
                logger.error("singleFileDelete error filePath is empty");
                return null;
            }
            return JSON.toJSONString(fastDFSService.deleteFile(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}