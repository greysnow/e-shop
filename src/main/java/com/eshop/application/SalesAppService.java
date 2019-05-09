package com.eshop.application;

import com.eshop.domain.model.Sales;

import java.util.List;

public interface SalesAppService {

    int addSales(Sales sales);

    List<Sales> queryAll();

    List<Sales> queryByGoodsBrand(String goodsBrand);
}
