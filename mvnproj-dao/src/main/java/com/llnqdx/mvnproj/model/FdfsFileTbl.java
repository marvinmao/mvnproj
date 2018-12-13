package com.llnqdx.mvnproj.model;

import com.llnqdx.mvnproj.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class FdfsFileTbl extends BaseEntity implements Serializable {
    private String uuid;

    private String fileName;

    private String fileUrl;

    private Integer fileLength;

    private Integer usedTime;

    private Date createTime;

    private Date updateTime;

    private Short deleteFlag;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
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

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}