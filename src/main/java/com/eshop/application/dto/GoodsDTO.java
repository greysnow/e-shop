package com.eshop.application.dto;

import com.eshop.domain.model.Goods;
import lombok.Data;

@Data
public class GoodsDTO {
    private Goods goods;
    private String sellerName;
}
