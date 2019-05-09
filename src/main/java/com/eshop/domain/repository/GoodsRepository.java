package com.eshop.domain.repository;

import com.eshop.domain.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsRepository {

     /**
      * 新增商品
      *
      * @param goods
      * @return
      * */
    int add(@Param("goods") Goods goods);

    /**
     * 删除商品
     *
     * @param goodsId
     * @return
     */
    int delete(@Param("goodsId") int goodsId);

    /**
     * 更新商品
     *
     * @param goods
     * @return
     */
    int update(@Param("goods") Goods goods);

    /**
     * 获得卖家商品
     *
     * @param sellerId
     * @return
     */
    List<Goods> queryBySellerId(@Param("sellerId") int sellerId);

    /**
     * 通过商品名称获得卖家商品
     *
     * @param sellerId
     * @param goodsName
     * @return
     */
    List<Goods> queryBySellerIdAndGoodsName(@Param("sellerId") int sellerId, @Param("goodsName") String goodsName);

    /**
     * 通过商品名称获得全部商品
     *
     * @param goodsName
     * @return
     */
    List<Goods> queryByGoodsName(@Param("goodsName") String goodsName);

    /**
     * 通过商品Id获得商品
     *
     * @param goodsId
     * @return
     */
    Goods queryByGoodsId(@Param("goodsId") int goodsId);

    /**
     * 获得所有商品
     *
     * @return
     */
    List<Goods> queryAllGoods();

    /**
     * 分页查询商品
     * @param start
     * @param limit
     * @return
     */
    List<Goods> findGoodss(@Param("start") int start, @Param("limit") int limit);

    /**
     * 获取goodsName
     *
     * @param goodsId
     * @return
     */
    String getGoodsName(@Param("goodsId") int goodsId);

    /**
     * 随着订单生成更新销量及库存
     *
     * @param goodsId
     * @param sales
     * @param stock
     * @return
     */
    int updateSalesAndStock(@Param("goodsId") int goodsId, @Param("sales") int sales, @Param("stock") int stock);

    /**
     * 根据GoodssID列表批量查询Goods列表
     * @param goodsIds
     * @return
     */
    List<Goods> findGoodss(@Param("goodsIds") List<Integer> goodsIds);

    List<Goods> queryByGoodsBrand(@Param("goodsBrand") String goodsBrand);
}