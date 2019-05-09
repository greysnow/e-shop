package com.eshop.application.impl;

import com.eshop.application.OrderAppService;
import com.eshop.application.dto.OrderDTO;
import com.eshop.domain.model.Goods;
import com.eshop.domain.model.Order;
import com.eshop.domain.model.Seller;
import com.eshop.domain.model.User;
import com.eshop.domain.repository.GoodsRepository;
import com.eshop.domain.repository.OrderRepository;
import com.eshop.domain.repository.SellerRepository;
import com.eshop.domain.repository.UserRepository;
import com.eshop.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderAppServiceImpl implements OrderAppService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public int addOrder(Order order) {
        int quantity = order.getQuantity();
        int goodsId = order.getGoodsId();
        Goods goods = goodsRepository.queryByGoodsId(goodsId);

        int currentSales = goods.getGoodsSales();
        int currentStock = goods.getGoodsStock();

        int newSales = currentSales + quantity;
        int newStock = currentStock - quantity;
        goodsRepository.updateSalesAndStock(goodsId, newSales, newStock);

        return orderRepository.add(order);
    }

    @Override
    public int deleteOrderById(int orderId) {
        Order order = orderRepository.queryByOrderId(orderId);
        int quantity = order.getQuantity();
        int goodsId = order.getGoodsId();
        Goods goods = goodsRepository.queryByGoodsId(goodsId);

        int currentSales = goods.getGoodsSales();
        int currentStock = goods.getGoodsStock();

        int newSales = currentSales - quantity;
        int newStock = currentStock + quantity;
        goodsRepository.updateSalesAndStock(goodsId, newSales, newStock);
        return orderRepository.delete(orderId);
    }

    @Override
    public List<OrderDTO> queryByUserId(int userId) {
        List<Order> orderList = orderRepository.queryByUserId(userId);
        if (CollectionUtils.isEmpty(orderList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> goodsIds = BeanUtils.extraProperty(orderList, "goodsId");
        List<Goods> goodsList = goodsRepository.findGoodss(goodsIds);
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> userIds = BeanUtils.extraProperty(orderList, "userId");
        List<User> userList = userRepository.findUsers(userIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }


        return buildOrder(orderList, goodsList, sellerList, userList);
    }

    @Override
    public List<OrderDTO> queryBySellerId(int sellerId) {
        List<Goods> goodsList = goodsRepository.queryBySellerId(sellerId);
        List<Integer> goodsIds = BeanUtils.extraProperty(goodsList, "goodsId");
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<OrderDTO>();
        }

        List<Order> orderList = orderRepository.findOrders(goodsIds);
        if (CollectionUtils.isEmpty(orderList)) {
            return new ArrayList<OrderDTO>();
        }

        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> userIds = BeanUtils.extraProperty(orderList, "userId");
        List<User> userList = userRepository.findUsers(userIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }

        return buildOrder(orderList, goodsList, sellerList, userList);
    }

    @Override
    public OrderDTO queryByOrderId(int orderId) {
        Order order = orderRepository.queryByOrderId(orderId);
        int userId = order.getUserId();
        String userName = userRepository.getUserName(userId);
        int goodsId = order.getGoodsId();
        Goods goods = goodsRepository.queryByGoodsId(goodsId);
        String goodsName = goods.getGoodsName();
        int sellerId = goods.getSellerId();
        String sellerName = sellerRepository.getSellerName(sellerId);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrder(order);
        orderDTO.setUserName(userName);
        orderDTO.setSellerName(sellerName);
        orderDTO.setGoodsName(goodsName);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> queryAllOrder() {
        List<Order> orderList =orderRepository.queryAll();
        if (CollectionUtils.isEmpty(orderList)) {
            return new ArrayList<OrderDTO>();
        }

        List<Integer> goodsIds = BeanUtils.extraProperty(orderList, "goodsId");
        List<Goods> goodsList = goodsRepository.findGoodss(goodsIds);
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<OrderDTO>();
        }

        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }

        List<Integer> userIds = BeanUtils.extraProperty(orderList, "userId");
        List<User> userList = userRepository.findUsers(userIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }

        return buildOrder(orderList, goodsList, sellerList, userList);
    }

    @Override
    public List<OrderDTO> findOrder(int start, int limit) {
        List<Order> orderList = orderRepository.findOrder(start, limit);
        if (CollectionUtils.isEmpty(orderList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> goodsIds = BeanUtils.extraProperty(orderList, "goodsId");
        List<Goods> goodsList = goodsRepository.findGoodss(goodsIds);
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }
        List<Integer> userIds = BeanUtils.extraProperty(orderList, "userId");
        List<User> userList = userRepository.findUsers(userIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<OrderDTO>();
        }


        return buildOrder(orderList, goodsList, sellerList, userList);
    }

    private List<OrderDTO> buildOrder(List<Order> orderList, List<Goods> goodsList, List<Seller> sellerList, List<User> userList ) {
        Map<Integer, Goods> goodsId2Goods = BeanUtils.mapBy(goodsList, "goodsId");
        Map<Integer, User> userId2User = BeanUtils.mapBy(userList, "userId");
        Map<Integer, Seller> sellerId2Seller = BeanUtils.mapBy(sellerList, "sellerId");
        List<OrderDTO> orderDTOMap = new ArrayList<OrderDTO>();
        for (Order order : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrder(order);

            Goods goods = goodsId2Goods.get(order.getGoodsId());
            if (goods != null) {
                orderDTO.setGoodsName(goods.getGoodsName());
            }

            Seller seller = sellerId2Seller.get(goods.getSellerId());
            if(seller != null){
                orderDTO.setSellerName(seller.getSellerName());
            }

            User user = userId2User.get(order.getUserId());
            if(user != null){
                orderDTO.setUserName(user.getUserName());
            }

            orderDTOMap.add(orderDTO);
        }
        return orderDTOMap;

    }

    @Override
    public List<Order> queryByOrderDate(Date orderDate){
        List<Order> orderList = orderRepository.queryByOrderDate(orderDate);
        return orderList;
    }
}