package com.eshop.access;

import com.eshop.application.SellerAppService;
import com.eshop.domain.model.Seller;
import com.eshop.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerAppService sellerAppService;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerLogin");
        modelAndView.addObject("sellerName", "测试用户名");
        return modelAndView;
    }

    //表单提交过来的路径
    @RequestMapping("/doLogin")
    public ModelAndView checkLogin(String sellerName, String password, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法
        boolean login = sellerAppService.checkLogin(sellerName, password);
        //若有seller则添加到model里并且跳转到成功页面
        if(login){
            LoginUtils.doLogin(response, sellerName, password);
            Seller seller = sellerAppService.querySellerByName(sellerName);
            int sellerId = seller.getSellerId();
            modelAndView.addObject("seller", seller);
            modelAndView.addObject("sellerId",sellerId);
            modelAndView.setViewName("sellerMessage");
            return modelAndView;
        }
        modelAndView.setViewName("fail");
        return modelAndView;
    }

    @RequestMapping("/allSeller")
    public String list(Model model) {
        List<Seller> list = sellerAppService.queryAllSeller();
        model.addAttribute("list", list);
        return "allSeller";
    }

    @RequestMapping("toAddSeller")
    public String toAddSeller() {
        return "addSeller";
    }

    @RequestMapping("/addSeller")
    public String addSeller(Seller seller) {
        sellerAppService.addSeller(seller);
        return "redirect:/seller/login";
    }
/*
    @RequestMapping("/del/{sellerId}")
    public String deleteSeller(@PathVariable("sellerId") int sellerId) {
        sellerAppService.deleteSellerById(sellerId);
        return "redirect:/seller/login";
    }
*/
    @RequestMapping("/del/{sellerId}")
    public ModelAndView deleteSeller(@PathVariable("sellerId") int sellerId) {
        ModelAndView modelAndView = new ModelAndView();
        sellerAppService.deleteSellerById(sellerId);
        modelAndView.setViewName("sellerLogin");
        return modelAndView;
    }

/*
    @RequestMapping("toUpdateSeller")
    public String toUpdateSeller(Model model, int sellerId) {
        model.addAttribute("seller", sellerAppService.querySellerById(sellerId));
        return "updateSeller";
    }
*/
    @RequestMapping("toUpdateSeller")
    public ModelAndView toUpdateSeller(int sellerId)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateSeller");
        modelAndView.addObject("sellerId",sellerId);
        modelAndView.addObject("seller",sellerAppService.querySellerById(sellerId));
        return modelAndView;
    }

    @RequestMapping("updateSeller")
    public ModelAndView updateSeller(Seller seller){
        int sellerId = seller.getSellerId();
        sellerAppService.updateSeller(seller);
        seller = sellerAppService.querySellerById(sellerId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sellerMessage");
        modelAndView.addObject("sellerId",sellerId);
        modelAndView.addObject("seller",seller);
        return modelAndView;
    }

    private Seller buildSeller(int sellerId, String sellerName, String sellerPwd, String sellerEmail, String sellerTel, String sellerAddress) {
        Seller seller = new Seller();
        seller.setSellerId(sellerId);
        seller.setSellerName(sellerName);
        seller.setSellerPwd(sellerPwd);
        seller.setSellerEmail(sellerEmail);
        seller.setSellerTel(sellerTel);
        seller.setSellerAddress(sellerAddress);
        return seller;
    }

    @RequestMapping("selectSellerId")
    public ModelAndView selectSellerId(Integer sellerId) {
        ModelAndView modelAndView = new ModelAndView();
        List<Seller> sellerList = new ArrayList<Seller>();
        if (sellerId == null) {
            sellerList = sellerAppService.queryAllSeller();
        } else {
            Seller seller = sellerAppService.querySellerById(sellerId);
            if(seller != null) {
                sellerList.add(seller);
            }
        }
        modelAndView.setViewName("allSeller");
        modelAndView.addObject("list", sellerList);
        return modelAndView;
    }
}
