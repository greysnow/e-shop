package com.eshop.application.dto;

import com.eshop.domain.model.SalesVolume;
import lombok.Data;

import java.util.Date;

@Data
public class SalesVolumeDTO {
    //salesVolume->salesQuantity
    //salesVolume->order->orderId->goods->goodsBrand
    //salesVolume->order->goodsId->orderDate 所有与brand相关的2019-04的销量
    //salesQuantity:
    // select sum(order.quantity)
    // From E_Order, E_Goods
    // Where orderDate like "2019-04" And goodsBrand = "Adidas"
    private SalesVolume salesVolume; //销量
    private String goodsBrand; //某个品牌
    private Date orderDate; //某个月
}
