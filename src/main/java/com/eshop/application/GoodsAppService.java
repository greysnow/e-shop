package com.eshop.application;

import com.eshop.application.dto.GoodsDTO;
import com.eshop.domain.model.Goods;

import java.util.List;

public interface GoodsAppService {
    int addGoods(Goods goods);

    int deleteGoodsById(int goodsId);

    int updateGoods(Goods goods);

    List<GoodsDTO> queryBySellerId(int sellerId);

    List<GoodsDTO> queryBySellerIdAndGoodsName(int sellerId, String goodsName);

    List<GoodsDTO> queryByGoodsName(String goodsName);

    GoodsDTO queryByGoodsId(int goodsId);

    List<GoodsDTO> queryAllGoods();

    /**
     * 分页查询商品
     * @param start
     * @param limit
     * @return
     */
    List<GoodsDTO> findGoods(int start, int limit);
}