package com.eshop.domain.model;

import lombok.Data;

@Data
public class SalesVolume {
    /**
     * 销售量Id
     */
    private int salesVolumeId;
    /**
     * 订单ID
     */
    private int orderId;
    /**
     * 销售量
     */
    private int salesQuantity;
}
