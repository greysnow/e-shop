package com.eshop.domain.model;

import lombok.Data;

@Data
public class SellerSales {
    /**
     * 订单ID
     */
    private int sellerSalesId;
    /**
     * 卖家ID
     */
    private int sellerId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 订单日期
     */
    private String orderDate;
    /**
     * 订单数量
     */
    private int quantity;
}