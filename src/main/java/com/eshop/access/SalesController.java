package com.eshop.access;

import com.eshop.application.SalesAppService;
import com.eshop.domain.model.Sales;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {

    @Resource
    SalesAppService salesAppService;

    @RequestMapping("allSalesVolume")
    public ModelAndView allSalesVolume(){
        ModelAndView modelAndView = new ModelAndView();
        List<Sales> salesList = salesAppService.queryAll();
        modelAndView.addObject("list", salesList);
        modelAndView.setViewName("salesVolume");
        return modelAndView;
    }

    @RequestMapping("queryByGoodsBrand")
    public ModelAndView queryByGoodsBrand(String goodsBrand){
        ModelAndView modelAndView = new ModelAndView();
        List<Sales> salesList = new ArrayList<Sales>();
        salesAppService.queryByGoodsBrand(goodsBrand);
        if(goodsBrand == null){
            salesList = salesAppService.queryAll();
        } else{
            salesList = salesAppService.queryByGoodsBrand(goodsBrand);
        }
        modelAndView.addObject("list", salesList);
        modelAndView.setViewName("salesVolume");
        return modelAndView;
    }

    @RequestMapping("toPredict")
    public ModelAndView toPredict(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("toPredict");
        return modelAndView;
    }
}
