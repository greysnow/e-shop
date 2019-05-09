package com.eshop.domain.model;

import lombok.Data;

@Data
public class Admin {
    /**
     * 管理员Id
     */
    private int adminId;
    /**
     * 管理员名称
     */
    private String adminName;
    /**
     * 管理员密码
     */
    private String adminPwd;
}
