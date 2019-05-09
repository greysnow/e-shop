package com.eshop.domain.repository;

import com.eshop.domain.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Date;

public interface OrderRepository {
    /**
     * 生成订单
     *
     * @param order
     * @return
     */
    int add(@Param("order") Order order);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    int delete(@Param("orderId") int orderId);

    /**
     * 获得用户订单
     *
     * @param userId
     * @return
     */
    List<Order> queryByUserId(@Param("userId") int userId);

    /**
     * 获得卖家订单
     *
     * @param goodsId
     * @return
     */
    List<Order> queryByGoodsId(@Param("goodsId") int goodsId);

    /**
     * 获得订单
     *
     * @param orderId
     * @return
     */
    Order queryByOrderId(@Param("orderId") int orderId);

    /**
     * 获得所有订单
     *
     * @return
     */
    List<Order> queryAll();

    /**
     * 获得用户Id
     *
     * @param orderId
     * @return
     */
    int getUserId(@Param("orderId") int orderId);

    /**
     * 获得商品Id
     *
     * @param orderId
     * @return
     */
    int getGoodsId(@Param("orderId") int orderId);

    /**
     * 分页查询商品
     * @param start
     * @param limit
     * @return
     */
    List<Order> findOrder(@Param("start") int start, @Param("limit") int limit);

    List<Order> queryByOrderDate(@Param("orderDate") Date orderDate);

    List<Order> findOrders(@Param("goodsIds") List<Integer> goodsIds);
}