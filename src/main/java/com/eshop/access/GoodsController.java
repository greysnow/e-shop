package com.eshop.access;

import com.eshop.application.GoodsAppService;
import com.eshop.application.SellerAppService;
import com.eshop.application.dto.GoodsDTO;
import com.eshop.domain.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsAppService goodsAppService;

    @Autowired
    private SellerAppService sellerAppService;

    @RequestMapping("allGoods")
    public ModelAndView list(int userId) {
        ModelAndView modelAndView = new ModelAndView();
        List<GoodsDTO> list = goodsAppService.queryAllGoods();
        modelAndView.addObject("list", list);
        modelAndView.addObject("userId",userId);
        modelAndView.setViewName("allGoods");
        return modelAndView;
    }

    @RequestMapping("allSellerGoods")
    public ModelAndView allSellerGoods(int sellerId) {
        ModelAndView modelAndView = new ModelAndView();
        List<GoodsDTO> list = goodsAppService.queryBySellerId(sellerId);
        modelAndView.setViewName("allSellerGoods");
        modelAndView.addObject("list", list);
        modelAndView.addObject("sellerId", sellerId);
        return modelAndView;
    }

    @RequestMapping("toAddGoods")
    public ModelAndView toAddGoods(int sellerId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sellerId", sellerId);
        modelAndView.setViewName("addGoods");
        return modelAndView;
    }

    @RequestMapping("addGoods")
    public ModelAndView addGoods(int sellerId, String goodsName, String goodsBrand, String goodsFor, String goodsType, int goodsStock, int goodsPrice){
        ModelAndView modelAndView = new ModelAndView();

        int goodsSales = 0;

        Goods goods = buildGoods(sellerId, goodsName, goodsBrand, goodsFor, goodsType, goodsStock, goodsSales, goodsPrice);
        goodsAppService.addGoods(goods);

        List<GoodsDTO> goodsDTOList = goodsAppService.queryBySellerId(sellerId);
        modelAndView.setViewName("allSellerGoods");
        modelAndView.addObject("list", goodsDTOList);
        modelAndView.addObject("sellerId", sellerId);
        return modelAndView;
    }

    private Goods buildGoods(int sellerId, String goodsName, String goodsBrand, String goodsFor, String goodsType, int goodsStock, int goodsSale, int goodsPrice){
        Goods goods = new Goods();
        goods.setSellerId(sellerId);
        goods.setGoodsName(goodsName);
        goods.setGoodsBrand(goodsBrand);
        goods.setGoodsFor(goodsFor);
        goods.setGoodsType(goodsType);
        goods.setGoodsStock(goodsStock);
        goods.setGoodsSales(goodsSale);
        goods.setGoodsPrice(goodsPrice);
        return goods;
    }

    @RequestMapping("del")
    public ModelAndView deleteGoods(int goodsId) {
        ModelAndView modelAndView = new ModelAndView();
        GoodsDTO goodsDTO = goodsAppService.queryByGoodsId(goodsId);
        int sellerId = goodsDTO.getGoods().getSellerId();
        goodsAppService.deleteGoodsById(goodsId);
        List<GoodsDTO> goodsDTOList = goodsAppService.queryBySellerId(sellerId);
        modelAndView.addObject("list", goodsDTOList);
        modelAndView.addObject("sellerId",sellerId);
        modelAndView.setViewName("allSellerGoods");
        return modelAndView;
    }

    @RequestMapping("toUpdateSellerGoods")
    public ModelAndView toUpdateSellerGoods(int goodsId){
        ModelAndView modelAndView = new ModelAndView();
        GoodsDTO goodsDTO = goodsAppService.queryByGoodsId(goodsId);
        Goods goods = goodsDTO.getGoods();
        modelAndView.setViewName("updateSellerGoods");
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }

    @RequestMapping("updateSellerGoods")
    public ModelAndView updateSellerGoods(Goods goods){
        ModelAndView modelAndView = new ModelAndView();
        int sellerId = goods.getSellerId();
        goodsAppService.updateGoods(goods);
        List<GoodsDTO> goodsDTOList = goodsAppService.queryBySellerId(sellerId);
        modelAndView.setViewName("allSellerGoods");
        modelAndView.addObject("sellerId",sellerId);
        modelAndView.addObject("list", goodsDTOList);
        return modelAndView;
    }
    
    @RequestMapping("/selectSellerGoodsName")
    public String selectSellerGoodsName(Model model, String goodsName, int sellerId) {
        List<GoodsDTO> goodsDTOList = new ArrayList<GoodsDTO>();
        if (goodsName == null) {
            goodsDTOList = goodsAppService.queryBySellerId(sellerId);
        } else {
            goodsDTOList = goodsAppService.queryBySellerIdAndGoodsName(sellerId, goodsName);
        }
        model.addAttribute("list", goodsDTOList);
        model.addAttribute("sellerId",sellerId);
        return "allSellerGoods";
    }

    @RequestMapping("/selectGoodsName")
    public String selectGoodsName(Model model, String goodsName, int userId) {
        List<GoodsDTO> goodsDTOList = new ArrayList<GoodsDTO>();
        if (goodsName == null) {
            goodsDTOList = goodsAppService.queryAllGoods();
        } else {
            goodsDTOList = goodsAppService.queryByGoodsName(goodsName);
        }
        model.addAttribute("list", goodsDTOList);
        model.addAttribute("userId",userId);
        return "allGoods";
    }

    @RequestMapping("allGoodsAdminVer")
    public ModelAndView allGoodsAdminVer() {
        ModelAndView modelAndView = new ModelAndView();
        List<GoodsDTO> goodsDTOList = new ArrayList<GoodsDTO>();
        goodsDTOList = goodsAppService.queryAllGoods();
        modelAndView.addObject("list", goodsDTOList);
        modelAndView.setViewName("allGoodsAdminVer");
        return modelAndView;
    }

    @RequestMapping("/selectGoodsNameAdminVer")
    public String selectGoodsNameAdminVer(Model model, String goodsName) {
        List<GoodsDTO> goodsDTOList = new ArrayList<GoodsDTO>();
        if (goodsName == null) {
            goodsDTOList = goodsAppService.queryAllGoods();
        } else {
            goodsDTOList = goodsAppService.queryByGoodsName(goodsName);
        }
        model.addAttribute("list", goodsDTOList);
        return "allGoodsAdminVer";
    }
}
