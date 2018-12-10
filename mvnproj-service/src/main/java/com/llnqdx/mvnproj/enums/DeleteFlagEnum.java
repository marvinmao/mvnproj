/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.llnqdx.mvnproj.enums;

/**
 * @Auther: maofujiang
 * @Date: 2018/12/8
 * @Description:
 */
public enum DeleteFlagEnum {
    INVALID_STATUS(-1, "invalid"),
    TRUE(0, "已删除"),
    FALSE(1, "未删除");

    private Integer key;
    private String description;

    DeleteFlagEnum(Integer key, String description) {
        this.key = key;
        this.description = description;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return description;
    }
}
