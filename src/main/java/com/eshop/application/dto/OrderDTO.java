package com.eshop.application.dto;

import com.eshop.domain.model.Order;
import lombok.Data;

@Data
public class OrderDTO {
    private Order order;
    private String userName;
    private String sellerName;
    private String goodsName;
}