package com.eshop.dao;

import com.eshop.domain.repository.SalesRepository;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesDaoTest extends BaseTest {
    @Autowired
    SalesRepository salesRepository;

    @Test
    public void testQueryAll(){
        salesRepository.queryAll();
    }

    @Test
    public void testQueryByGoodsBrand(){
        String goodsBrand = "Adidas";
        salesRepository.queryByGoodsBrand(goodsBrand);
    }

    @Test
    public void testQueryByGoodsBrandAndOrderDate(){
        String goodsBrand = "Adidas";
        String orderDate = "2018-12";
        salesRepository.queryByGoodsBrandAndOrderDate(goodsBrand, orderDate);
    }
}
