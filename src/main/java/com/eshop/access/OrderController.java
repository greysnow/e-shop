package com.eshop.access;

import com.eshop.application.GoodsAppService;
import com.eshop.application.OrderAppService;
import com.eshop.application.SellerAppService;
import com.eshop.application.UserAppService;
import com.eshop.application.dto.GoodsDTO;
import com.eshop.application.dto.OrderDTO;
import com.eshop.domain.model.Order;
import com.eshop.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserAppService userAppService;

    @Autowired
    private OrderAppService orderAppService;

    @Autowired
    private SellerAppService sellerAppService;

    @Autowired
    private GoodsAppService goodsAppService;

    @RequestMapping("/allOrder")
    public String list(Model model) {
        List<OrderDTO> orderDTOList = orderAppService.queryAllOrder();
        model.addAttribute("list", orderDTOList);
        return "allOrder";
    }

    @RequestMapping("toAddOrder")
    public ModelAndView toAddOrder(int goodsId) {
        ModelAndView modelAndView = new ModelAndView();
        GoodsDTO goodsDTO = goodsAppService.queryByGoodsId(goodsId);
        modelAndView.setViewName("addOrder");
        modelAndView.addObject("goodsId", goodsId);
        modelAndView.addObject("goodsDTO", goodsDTO);
        return modelAndView;
    }

    @RequestMapping("addOrder")
    public ModelAndView addOrder(int goodsId, int quantity, @CookieValue("_u") String userName) {
        ModelAndView modelAndView = new ModelAndView();

        GoodsDTO goodsDTO = goodsAppService.queryByGoodsId(goodsId);
        int goodsPrice =  goodsDTO.getGoods().getGoodsPrice();

        User user = userAppService.queryUserByName(userName);
        int userId = user.getUserId();

        Date orderDate = new Date();
        int total = quantity * goodsPrice;

        Order order = buildOrder(userId, goodsId, orderDate, quantity, total);
        orderAppService.addOrder(order);

        List<OrderDTO> orderDTOList = orderAppService.queryByUserId(userId);
        modelAndView.addObject("list",orderDTOList);
        modelAndView.addObject("userId",userId);
        modelAndView.setViewName("allUserOrder");
        return modelAndView;
    }


    private Order buildOrder(int userId, int goodsId, Date orderDate, int quantity, int total) {
        Order order = new Order();
        order.setUserId(userId);
        order.setGoodsId(goodsId);
        order.setOrderDate(orderDate);
        order.setQuantity(quantity);
        order.setTotal(total);
        return order;
    }

    @RequestMapping("del")
    public ModelAndView deleteOrder(int orderId) {
        ModelAndView modelAndView = new ModelAndView();
        OrderDTO orderDTO = orderAppService.queryByOrderId(orderId);
        int userId = orderDTO.getOrder().getUserId();
        orderAppService.deleteOrderById(orderId);
        List<OrderDTO> orderDTOList = orderAppService.queryByUserId(userId);
        modelAndView.setViewName("allUserOrder");
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("list",orderDTOList);
        return modelAndView;
    }

    @RequestMapping("allSellerOrder")
    public ModelAndView allSellerOrder(int sellerId){
        ModelAndView modelAndView = new ModelAndView();
        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
        orderDTOList = orderAppService.queryBySellerId(sellerId);
        modelAndView.addObject("list",orderDTOList);
        modelAndView.addObject("sellerId",sellerId);
        modelAndView.setViewName("allSellerOrder");
        return modelAndView;
    }

    @RequestMapping("allUserOrder")
    public ModelAndView allUserOrder(int userId){
        ModelAndView modelAndView = new ModelAndView();
        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
        orderDTOList = orderAppService.queryByUserId(userId);
        modelAndView.addObject("list",orderDTOList);
        modelAndView.addObject("userId",userId);
        modelAndView.setViewName("allUserOrder");
        return modelAndView;
    }

    @RequestMapping("selectOrderId")
    public ModelAndView selectOrderId(Integer orderId){
        ModelAndView modelAndView = new ModelAndView();
        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
        if(orderId == null) {
            orderDTOList = orderAppService.queryAllOrder();
        }
        else {
            OrderDTO orderDTO = orderAppService.queryByOrderId(orderId);
            if(orderDTO != null) {
                orderDTOList.add(orderDTO);
            }
        }
        modelAndView.addObject("list", orderDTOList);
        modelAndView.setViewName("allOrder");
        return modelAndView;
    }
}
