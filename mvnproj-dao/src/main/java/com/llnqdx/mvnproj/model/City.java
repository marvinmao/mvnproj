package com.llnqdx.mvnproj.model;

import com.llnqdx.mvnproj.base.BaseEntity;

import java.io.Serializable;

public class City extends BaseEntity implements Serializable {
    private String city;

    private Integer cid;

    private Integer pid;

    private static final long serialVersionUID = 1L;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}