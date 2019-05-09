package com.eshop.domain.repository;

import com.eshop.domain.model.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesRepository {
    /**
     * 加入表中
     * @param sales
     * @return
     */
    int add(@Param("sales") Sales sales);

    /**
     * 查所有销售量
     *
     * @return
     */
    List<Sales> queryAll();

    /**
     * 获取某品牌某月销售量
     *
     * @param goodsBrand
     * @param orderDate
     * @return
     */
    Sales queryByGoodsBrandAndOrderDate(@Param("goodsBrand") String goodsBrand, @Param("orderDate") String orderDate);

    /**
     * 获取某品牌销售量
     *
     * @param goodsBrand
     * @return
     */
    List<Sales> queryByGoodsBrand(@Param("goodsBrand") String goodsBrand);
}
