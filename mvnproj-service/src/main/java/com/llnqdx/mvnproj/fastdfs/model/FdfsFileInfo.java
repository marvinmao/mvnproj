package com.llnqdx.mvnproj.fastdfs.model;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: marvinmao
 * @Date: 2018/12/8
 */
public class FdfsFileInfo implements Serializable {

    private String uuid;

    private String fileName;

    private String fileUrl;

    private String downloadUrl;

    private Integer fileLength;

    private Integer usedTime;

    private String createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getFileLength() {
        return fileLength;
    }

    public void setFileLength(Integer fileLength) {
        this.fileLength = fileLength;
    }

    public Integer getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Integer usedTime) {
        this.usedTime = usedTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

//    public FdfsFileInfo(String fileName, String fileUrl, Integer fileLength, Integer usedTime) {
//        this.fileName = fileName;
//        this.fileUrl = fileUrl;
//        this.fileLength = fileLength;
//        this.usedTime = usedTime;
//    }
}