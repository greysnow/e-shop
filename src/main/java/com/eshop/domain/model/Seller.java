package com.eshop.domain.model;

import lombok.Data;

@Data
public class Seller {
    /**
     * 卖家ID
     */
    private int sellerId;
    /**
     * 卖家名字
     */
    private String sellerName;
    /**
     * 卖家密码
     */
    private String sellerPwd;
    /**
     * 卖家邮件
     */
    private String sellerEmail;
    /**
     * 卖家电话
     */
    private String sellerTel;
    /**
     * 卖家地址
     */
    private String sellerAddress;
}
