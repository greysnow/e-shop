package com.eshop.domain.model;

import lombok.Data;

@Data
public class User {
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户电话
     */
    private String userTel;
    /**
     * 用户地址
     */
    private String userAddress;
}