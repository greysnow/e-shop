package com.eshop.domain.repository;

import com.eshop.domain.model.Seller;
import com.eshop.utils.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by float.lu on 3/31/19.
 */
public class SellerRepositoryTest extends BaseTest {

    @Resource
    private SellerRepository sellerRepository;

    @Test
    public void test_seller_add() throws Exception {
        Seller seller = new Seller();
        seller.setSellerName("float.lu");
        seller.setSellerPwd("123");
        seller.setSellerTel("13122068908");
        seller.setSellerAddress("地址");
        seller.setSellerEmail("aa@aa.com");
        sellerRepository.add(seller);
    }
}
