package com.eshop.access;

import com.eshop.application.GoodsAppService;
import com.eshop.application.OrderAppService;
import com.eshop.application.SalesVolumeAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salesVolume")
public class SalesVolumeController {
    @Autowired
    SalesVolumeAppService salesVolumeAppService;
    @Autowired
    OrderAppService orderAppService;
    @Autowired
    GoodsAppService goodsAppService;
/*
    @RequestMapping("selectVolumeGoodsBrand")
    public ModelAndView selectGoodsBrand(String goodsBrand){
        ModelAndView modelAndView = new ModelAndView();
        List<SalesVolumeDTO> salesVolumeDTOList = salesVolumeAppService.queryByGoodsBrand(goodsBrand);
        modelAndView.setViewName("salesVolume");
        modelAndView.addObject("list", salesVolumeDTOList);
        return modelAndView;
    }
*/
}
