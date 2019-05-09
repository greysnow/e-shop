package com.eshop.domain.model;

import lombok.Data;

@Data
public class Sales {
    /**
     * 订单ID
     */
    private int salesId;
    /**
     * 商品品牌
     */
    private String goodsBrand;
    /**
     * 订单日期
     */
    private String orderDate;
    /**
     * 订单数量
     */
    private int quantity;
}
