package com.eshop.application.impl;

import com.eshop.application.GoodsAppService;
import com.eshop.application.dto.GoodsDTO;
import com.eshop.domain.model.Goods;
import com.eshop.domain.model.Seller;
import com.eshop.domain.repository.GoodsRepository;
import com.eshop.domain.repository.SellerRepository;
import com.eshop.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GoodsAppServiceImpl implements GoodsAppService {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public int addGoods(Goods goods) {
        return goodsRepository.add(goods);
    }

    @Override
    public int deleteGoodsById(int goodsId) { return goodsRepository.delete(goodsId); }

    @Override
    public int updateGoods(Goods goods) { return goodsRepository.update(goods); }

    @Override
    public List<GoodsDTO> queryBySellerId(int sellerId) {
        List<Goods> goodsList = goodsRepository.queryBySellerId(sellerId);

        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<GoodsDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<GoodsDTO>();
        }

        return buildGoods(goodsList, sellerList);
    }

    @Override
    public List<GoodsDTO> queryBySellerIdAndGoodsName(int sellerId, String goodsName) {
        List<Goods> goodsList = goodsRepository.queryBySellerIdAndGoodsName(sellerId, goodsName);

        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<GoodsDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<GoodsDTO>();
        }

        return buildGoods(goodsList, sellerList);
    }

    @Override
    public List<GoodsDTO> queryByGoodsName(String goodsName) {
        List<Goods> goodsList = goodsRepository.queryByGoodsName(goodsName);
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<GoodsDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<GoodsDTO>();
        }

        return buildGoods(goodsList, sellerList);
    }

    @Override
    public GoodsDTO queryByGoodsId(int goodsId) {
        Goods goods = goodsRepository.queryByGoodsId(goodsId);
        int sellerId = goods.getSellerId();
        String sellerName = sellerRepository.getSellerName(sellerId);
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setGoods(goods);
        goodsDTO.setSellerName(sellerName);
        return goodsDTO;
    }

    @Override
    public List<GoodsDTO> queryAllGoods(){
        List<Goods> goodsList = goodsRepository.queryAllGoods();
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<GoodsDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<GoodsDTO>();
        }

        return buildGoods(goodsList, sellerList);
    }


    @Override
    public List<GoodsDTO> findGoods(int start, int limit) {
        List<Goods> goodsList = goodsRepository.findGoodss(start, limit);
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<GoodsDTO>();
        }
        List<Integer> sellerIds = BeanUtils.extraProperty(goodsList, "sellerId");
        List<Seller> sellerList = sellerRepository.findSellers(sellerIds);
        if (CollectionUtils.isEmpty(sellerList)) {
            return new ArrayList<GoodsDTO>();
        }

        return buildGoods(goodsList, sellerList);
    }

    private List<GoodsDTO> buildGoods(List<Goods> goodsList, List<Seller> sellerList ) {
        Map<Integer, Seller> sellerId2Seller = BeanUtils.mapBy(sellerList, "sellerId");
        List<GoodsDTO> goodsDTOMap = new ArrayList<GoodsDTO>();
        for (Goods goods : goodsList) {
            GoodsDTO goodsDTO = new GoodsDTO();
            goodsDTO.setGoods(goods);

            Seller seller = sellerId2Seller.get(goods.getSellerId());
            if (seller != null) {
                goodsDTO.setSellerName(seller.getSellerName());
            }
            goodsDTOMap.add(goodsDTO);
        }
        return goodsDTOMap;

    }
}