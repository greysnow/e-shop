package com.eshop.domain.repository;

import com.eshop.domain.model.SellerSales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerSalesRepository {
    /**
     * 加入表中
     * @param sellerSales
     * @return
     */
    int add(@Param("sellerSales") SellerSales sellerSales);

    /**
     * 查所有销售量
     *
     * @return
     */
    List<SellerSales> queryAll();

    /**
     * 获取某卖家某商品某月销售量
     *
     * @param goodsName
     * @param orderDate
     * @param sellerId
     * @return
     */
    SellerSales queryByGoodsNameAndOrderDate(@Param("goodsName") String goodsName, @Param("orderDate") String orderDate, @Param("sellerId") int sellerId);

    /**
     * 获取某卖家某商品的销售量
     *
     * @param goodsName
     * @param sellerId
     * @return
     */
    List<SellerSales> queryByGoodsName(@Param("goodsName") String goodsName, @Param("sellerId") int sellerId);

    /**
     * 查看某卖家的商品销售量
     *
     * @param sellerId
     * @return
     */
    List<SellerSales> queryBySellerId(@Param("sellerId") int sellerId);
}
