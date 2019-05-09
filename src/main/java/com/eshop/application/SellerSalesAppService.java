package com.eshop.application;

import com.eshop.domain.model.SellerSales;

import java.util.List;

public interface SellerSalesAppService {

    int addSellerSales(SellerSales sellerSales);

    List<SellerSales> queryAll();

    List<SellerSales> queryByGoodsName(String goodsName, int sellerId);

    List<SellerSales> queryBySellerId(int sellerId);
}