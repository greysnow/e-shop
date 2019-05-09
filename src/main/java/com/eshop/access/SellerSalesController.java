package com.eshop.access;

import com.eshop.application.SellerSalesAppService;
import com.eshop.domain.model.SellerSales;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sellerSales")
public class SellerSalesController {

    @Resource
    SellerSalesAppService sellerSalesAppService;

    @RequestMapping("sellerSalesVolume")
    public ModelAndView sellerSalesVolume(int sellerId){
        ModelAndView modelAndView = new ModelAndView();
        List<SellerSales> sellerSalesList = sellerSalesAppService.queryBySellerId(sellerId);
        modelAndView.addObject("list", sellerSalesList);
        modelAndView.addObject("sellerId", sellerId);
        modelAndView.setViewName("sellerSalesVolume");
        return modelAndView;
    }

    @RequestMapping("queryByGoodsName")
    public ModelAndView queryByGoodsName(String goodsName, int sellerId){
        ModelAndView modelAndView = new ModelAndView();
        List<SellerSales> sellerSalesList = new ArrayList<SellerSales>();
        sellerSalesAppService.queryBySellerId(sellerId);
        if(goodsName == null){
            sellerSalesList = sellerSalesAppService.queryBySellerId(sellerId);
        } else{
            sellerSalesList = sellerSalesAppService.queryByGoodsName(goodsName, sellerId);
        }
        modelAndView.addObject("list", sellerSalesList);
        modelAndView.addObject("sellerId", sellerId);
        modelAndView.setViewName("sellerSalesVolume");
        return modelAndView;
    }

    @RequestMapping("toSellerPredict")
    public ModelAndView toSellerPredict(int sellerId){
        ModelAndView modelAndView = new ModelAndView();
        if(sellerId == 1){
            modelAndView.setViewName("toSellerPredict1");
        } else if(sellerId == 4){
            modelAndView.setViewName("toSellerPredict4");
        } else if(sellerId == 5){
            modelAndView.setViewName("toSellerPredict5");
        } else if(sellerId == 6){
            modelAndView.setViewName("toSellerPredict6");
        } else if(sellerId == 7){
            modelAndView.setViewName("toSellerPredict7");
        }
        return modelAndView;
    }
}
