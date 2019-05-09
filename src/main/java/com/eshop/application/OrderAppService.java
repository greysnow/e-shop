package com.eshop.application;

import com.eshop.application.dto.OrderDTO;
import com.eshop.domain.model.Order;

import java.util.List;
import java.util.Date;

public interface OrderAppService {
    int addOrder(Order order);

    int deleteOrderById(int orderId);

    List<OrderDTO> queryByUserId(int userId);

    List<OrderDTO> queryBySellerId(int sellerId);

    OrderDTO queryByOrderId(int orderId);

    List<OrderDTO> queryAllOrder();

    List<Order> queryByOrderDate(Date orderDate);

    /**
     * 分页查询商品
     *
     * @param start
     * @param limit
     * @return
     */
    List<OrderDTO> findOrder(int start, int limit);
}