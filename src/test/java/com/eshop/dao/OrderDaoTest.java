package com.eshop.dao;

import com.eshop.domain.model.Order;
import com.eshop.domain.repository.OrderRepository;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class OrderDaoTest extends BaseTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testAdd() {
        Order order = new Order();

        Date date = new Date();
        System.out.print(date);
        order.setUserId(3);
        order.setGoodsId(4);
        order.setQuantity(1);
        order.setOrderDate(date);
        order.setTotal(275);

        int i = orderRepository.add(order);

        System.out.print(i);
    }

    @Test
    public void testQueryByUserId(){
        int userId = 1;
        orderRepository.queryByUserId(userId);
    }

    @Test
    public void testQueryByGoodsId(){
        int goodsId = 1;
        orderRepository.queryByGoodsId(goodsId);
    }

    @Test
    public void testQueryByOrderId(){
        int orderId = 1;
        orderRepository.queryByOrderId(orderId);
    }

    @Test
    public void testQueryAll(){
        orderRepository.queryAll();
    }

    @Test
    public void testGetUserId(){
        int orderId = 1;
        orderRepository.getUserId(orderId);
    }
    @Test
    public void testGetGoodsId(){
        int orderId = 1;
        orderRepository.getGoodsId(orderId);
    }

}