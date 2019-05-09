package com.eshop.application.impl;

import com.eshop.application.SellerSalesAppService;
import com.eshop.domain.model.SellerSales;
import com.eshop.domain.repository.SellerSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerSalesAppServiceImpl implements SellerSalesAppService {

    @Autowired
    SellerSalesRepository sellerSalesRepository;

    @Override
    public int addSellerSales(SellerSales sellerSales) {
        return sellerSalesRepository.add(sellerSales);
    }

    @Override
    public List<SellerSales> queryAll(){
        List<SellerSales> sellerSalesList = sellerSalesRepository.queryAll();
        return sellerSalesList;
    }

    @Override
    public List<SellerSales> queryByGoodsName(String goodsName, int sellerId){
        List<SellerSales> sellerSalesList = sellerSalesRepository.queryByGoodsName(goodsName, sellerId);
        return sellerSalesList;
    }

    @Override
    public List<SellerSales> queryBySellerId(int sellerId){
        List<SellerSales> sellerSalesList = sellerSalesRepository.queryBySellerId(sellerId);
        return sellerSalesList;
    }
}
