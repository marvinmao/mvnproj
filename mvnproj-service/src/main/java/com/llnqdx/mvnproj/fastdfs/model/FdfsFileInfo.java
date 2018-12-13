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

    private String fileMd5;

    private Integer fileLength;

    private Integer fileSize;

    private Integer usedTime;

    private Double avgUploadSpleed;

    private Integer imgWidth;

    private Integer imgHeight;

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

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Double getAvgUploadSpleed() {
        return avgUploadSpleed;
    }

    public void setAvgUploadSpleed(Double avgUploadSpleed) {
        this.avgUploadSpleed = avgUploadSpleed;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }
}