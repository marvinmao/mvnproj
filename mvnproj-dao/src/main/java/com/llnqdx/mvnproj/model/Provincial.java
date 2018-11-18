package com.llnqdx.mvnproj.model;

import com.llnqdx.mvnproj.base.BaseEntity;

import java.io.Serializable;

public class Provincial extends BaseEntity implements Serializable {
    private Integer pid;

    private String provincial;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial == null ? null : provincial.trim();
    }
}