package com.eshop.dao;

import com.eshop.domain.model.Seller;
import com.eshop.domain.repository.SellerRepository;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;

public class SellerDaoTest extends BaseTest {
    @Autowired
    SellerRepository sellerRepository;


    @Test
    public void testQueryAll(){
        List<Seller> sellers = sellerRepository.queryAll();

        System.out.print(sellers.size());
    }
    @Test
    public void testAdd(){
        Seller seller = new Seller();

        seller.setSellerName("John");
        seller.setSellerPwd("123456");
        seller.setSellerTel("13153338233");
        seller.setSellerEmail("Dog@163.com");
        seller.setSellerAddress("上海市松江区");

        int i = sellerRepository.add(seller);

        System.out.print(i);
    }
    @Test
    public void testDelete(){
        int sellerId = 2;

        int i = sellerRepository.delete(sellerId);

        System.out.print(i);
    }
    @Test
    public void testUpdate(){
        Seller seller = new Seller();

        seller.setSellerId(1);
        seller.setSellerPwd("123456");
        seller.setSellerTel("13156668233");
        seller.setSellerEmail("John@163.com");
        seller.setSellerAddress("上海市松江区");

        int i = sellerRepository.update(seller);

        System.out.print(i);
    }
    @Test
    public void testLoad(){
        int sellerId = 1;

        Seller seller = sellerRepository.load(sellerId);

    }
    @Test
    public void testGetSellerName(){
        int sellerId = 1;

        String str = sellerRepository.getSellerName(sellerId);

        System.out.print(str);
    }
    @Test
    public void testGetSellerId(){
        String sellerName = "Dog";

        int i = sellerRepository.getSellerId(sellerName);

        System.out.print(i);
    }


    @Test
    public void testFindSellers() {
        List<Integer> sellerIds = new ArrayList<Integer>(){{
            add(1);
        }};
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        Assert.that(sellerList != null && sellerIds.size() > 0, "no result!");
    }
}
