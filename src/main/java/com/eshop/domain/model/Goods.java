package com.eshop.domain.model;

import lombok.Data;

@Data
public class Goods {
    /**
     * 商品Id
     */
    private int goodsId;
    /**
     * 卖家Id
     */
    private int sellerId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品品牌
     */
    private String goodsBrand;
    /**
     * 商品类型
     */
    private String goodsType;
    /**
     * 男女款式
     */
    private String goodsFor;
    /**
     * 商品库存
     */
    private int goodsStock;
    /**
     * 销售总量
     */
    private int goodsSales;
    /**
     * 商品价格
     */
    private int goodsPrice;
}
