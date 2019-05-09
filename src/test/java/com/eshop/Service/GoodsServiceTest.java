package com.eshop.Service;

import com.eshop.application.GoodsAppService;
import com.eshop.application.dto.GoodsDTO;
import com.eshop.domain.model.Goods;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsServiceTest extends BaseTest {
    @Autowired
    GoodsAppService goodsAppService;

    @Test
    public void testAddGoods(){
        Goods goods = new Goods();

        goods.setSellerId(1);
        goods.setGoodsName("Adidas N5");
        goods.setGoodsBrand("Adidas");
        goods.setGoodsType("跑步款");
        goods.setGoodsFor("女");
        goods.setGoodsStock(300);
        goods.setGoodsPrice(320);

        goodsAppService.addGoods(goods);
    }
    @Test
    public void testDeleteGoodsById(){
        int goodsId = 7;
        goodsAppService.deleteGoodsById(goodsId);
    }
    @Test
    public void testUpdateGoods(){
        Goods goods = new Goods();

        goods.setGoodsId(8);
        goods.setGoodsName("Adidas N7");
        goods.setGoodsBrand("Adidas");
        goods.setGoodsType("篮球款");
        goods.setGoodsFor("女");
        goods.setGoodsStock(300);
        goods.setGoodsPrice(320);

        goodsAppService.updateGoods(goods);
    }

    @Test
    public void testQueryBySellerId(){
        int sellerId = 1;
        List<GoodsDTO> goodsDTOS = goodsAppService.queryBySellerId(sellerId);
        System.out.print(goodsDTOS.size());
    }
    @Test
    public void testQueryBySellerIdAndGoodsName(){
        int sellerId = 1;
        String goodsName = "Adidas";
        List<GoodsDTO> goodsDTOS = goodsAppService.queryBySellerIdAndGoodsName(sellerId, goodsName);
        System.out.print(goodsDTOS.size());
    }
    @Test
    public void testQueryByGoodsName(){
        String goodsName = "Adidas";
        List<GoodsDTO> goodsDTOS = goodsAppService.queryByGoodsName(goodsName);
        System.out.print(goodsDTOS.size());
    }
    @Test
    public void testQueryByGoodsId() {
        GoodsDTO goodsDTO = goodsAppService.queryByGoodsId(1);
        System.out.print(goodsDTO);
    }
    @Test
    public void testFindGoods(){
        List<GoodsDTO> goodsDTOS = goodsAppService.findGoods(0,10);
        System.out.print(goodsDTOS.size());
    }
}
