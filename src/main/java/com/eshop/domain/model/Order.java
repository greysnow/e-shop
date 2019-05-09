package com.eshop.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    /**
     * 订单ID
     */
    private int orderId;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 商品ID
     */
    private int goodsId;
    /**
     * 订单日期
     */
    private Date orderDate;
    /**
     * 订单数量
     */
    private int quantity;
    /**
     * 价值总额
     */
    private int total;
}
