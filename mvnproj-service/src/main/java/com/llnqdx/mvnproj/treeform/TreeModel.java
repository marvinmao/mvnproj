package com.llnqdx.mvnproj.treeform;

import java.util.List;

/**
 * @Auther: marvinmao
 * @Date: 2019/4/28
 * @Description:
 */
public class TreeModel {

    private String uuid;

    private String name;

    private String parentId;

    private List<TreeModel> childList;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeModel> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeModel> childList) {
        this.childList = childList;
    }
}
