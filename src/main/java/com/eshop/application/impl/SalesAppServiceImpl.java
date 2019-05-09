package com.eshop.application.impl;

import com.eshop.application.SalesAppService;
import com.eshop.domain.model.Sales;
import com.eshop.domain.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAppServiceImpl implements SalesAppService {

    @Autowired
    SalesRepository salesRepository;

    @Override
    public int addSales(Sales sales) {
        return salesRepository.add(sales);
    }

    @Override
    public List<Sales> queryAll(){
        List<Sales> salesList = salesRepository.queryAll();
        return salesList;
    }

    @Override
    public List<Sales> queryByGoodsBrand(String goodsBrand){
        List<Sales> salesList = salesRepository.queryByGoodsBrand(goodsBrand);
        return salesList;
    }
}
