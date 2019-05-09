package com.eshop.dao;

import com.eshop.domain.model.Goods;
import com.eshop.domain.repository.GoodsRepository;
import com.eshop.utils.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsDaoTest extends BaseTest {
    @Autowired
    GoodsRepository goodsRepository;

    @Test
    public void testAdd(){
        Goods goods = new Goods();

        goods.setSellerId(2);
        goods.setGoodsName("Adidas N8");
        goods.setGoodsBrand("Adidas");
        goods.setGoodsType("休闲款");
        goods.setGoodsFor("男");
        goods.setGoodsStock(200);
        goods.setGoodsPrice(275);

        int i = goodsRepository.add(goods);

        System.out.print(i);
    }
    @Test
    public void testDelete(){
        int goodsId = 1;

        int i = goodsRepository.delete(goodsId);

        System.out.print(i);
    }
    @Test
    public void testUpdate(){
        Goods goods = new Goods();

        goods.setGoodsId(1);
        goods.setGoodsName("Adidas N9");
        goods.setGoodsBrand("Adidas");
        goods.setGoodsType("休闲款");
        goods.setGoodsFor("男");
        goods.setGoodsStock(232);
        goods.setGoodsSales(0);
        goods.setGoodsPrice(310);

        int i = goodsRepository.update(goods);

        System.out.print(i);
    }
    @Test
    public void testQueryBySellerId(){
        int sellerId = 1;
        goodsRepository.queryBySellerId(sellerId);
    }
    @Test
    public void testQueryBySellerIdAndGoodsName(){
        int sellerId = 1;
        String goodsName = "Adidas";
        goodsRepository.queryBySellerIdAndGoodsName(sellerId, goodsName);
    }
    @Test
    public void testQueryByGoodsName(){
        String goodsName = "Adidas";
        goodsRepository.queryByGoodsName(goodsName);
    }
    @Test
    public void testQueryByGoodsId(){
        int goodsId = 1;
        goodsRepository.queryByGoodsId(goodsId);
    }
    @Test
    public void testQueryAllGoods(){

        goodsRepository.queryAllGoods();
    }
    @Test
    public void testGetGoodsName(){
        int goodsId = 1;
        goodsRepository.getGoodsName(goodsId);
    }
    @Test
    public void testUpdateSalesAndStock(){
        int goodsId = 1;
        int sales = 1;
        int stock = 219;
        goodsRepository.updateSalesAndStock(goodsId, sales, stock);
    }

    @Test
    public void testFindGoods() {
        List<Goods> goodsList = goodsRepository.findGoodss(0, 10);
        Assert.assertTrue(goodsList != null && goodsList.size() > 0);
    }
}