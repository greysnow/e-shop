package com.eshop.domain.repository;

import com.eshop.domain.model.Seller;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerRepository {

    /**
     * 新增卖家
     *
     * @param seller
     * @return
     */
    int add(@Param("seller") Seller seller);

    /**
     * 删除卖家
     *
     * @param sellerId
     * @return
     */
    int delete(int sellerId);

    /**
     * 更新Seller
     *
     * @param seller
     * @return
     */
    int update(@Param("seller") Seller seller);

    /**
     * 加载单个卖家
     *
     * @param sellerId
     * @return
     */
    Seller load(int sellerId);

    /**
     * 查询所有的卖家
     *
     * @return
     */
    List<Seller> queryAll();

    /**
     * 通过SellerName获取SellerId
     *
     * @param sellerName
     * @return
     */
    int getSellerId(String sellerName);

    /**
     * 获取SellerName
     *
     * @param sellerId
     * @return
     */
    String getSellerName(int sellerId);

    /**
     * 获取用户密码
     *
     * @param sellerName
     * @return
     */
    String getSellerPwd(String sellerName);

    /**
     * 根据SellersID列表批量查询Seller列表
     * @param sellerIds
     * @return
     */
    List<Seller> findSellers(@Param("sellerIds") List<Integer> sellerIds);
}
