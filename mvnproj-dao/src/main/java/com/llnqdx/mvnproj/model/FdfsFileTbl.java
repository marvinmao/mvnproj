package com.llnqdx.mvnproj.model;

import com.llnqdx.mvnproj.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class FdfsFileTbl extends BaseEntity implements Serializable {
    private Integer id;

    private String fileName;

    private String fileUrl;
    private String filePath;

    private Integer fileLength;

    private Integer usedTime;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public FdfsFileTbl(String fileName, String fileUrl, Integer fileLength, Integer usedTime, Date createTime, Date updateTime) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.fileLength = fileLength;
        this.usedTime = usedTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}