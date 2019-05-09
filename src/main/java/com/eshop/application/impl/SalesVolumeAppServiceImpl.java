package com.eshop.application.impl;

import com.eshop.application.SalesVolumeAppService;
import com.eshop.application.dto.SalesVolumeDTO;
import com.eshop.domain.model.*;
import com.eshop.domain.repository.*;
import com.eshop.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SalesVolumeAppServiceImpl implements SalesVolumeAppService {

    @Autowired
    SalesVolumeRepository salesVolumeRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GoodsRepository goodsRepository;

    @Resource
    SalesRepository salesRepository;

    @Autowired
    SellerSalesRepository sellerSalesRepository;

    public void getVolume() {
        List<String> goodsBrandList = new ArrayList<String>();
        goodsBrandList.add("Adidas");
        goodsBrandList.add("LINING");
        goodsBrandList.add("ANTA");
        goodsBrandList.add("Nike");
        goodsBrandList.add("kappa");

        List<String> dateList = new ArrayList<String>();
        dateList.add("2018-11");
        dateList.add("2018-12");
        dateList.add("2019-01");
        dateList.add("2019-02");
        dateList.add("2019-03");
        dateList.add("2019-04");

        for(String goodsBrand : goodsBrandList){
            List<Goods> goodsList = goodsRepository.queryByGoodsBrand(goodsBrand);
            List<Integer> goodsIds = BeanUtils.extraProperty(goodsList, "goodsId");

            List<Order> orderList = orderRepository.findOrders(goodsIds);

            List<Integer> sumList = new ArrayList<Integer>();
            for (String date : dateList) {
                //销售量
                int sum = 0;
                for (Order order : orderList) {
                    String str = new java.text.SimpleDateFormat("yyyy-MM-dd").format(order.getOrderDate());
                    String temp = str.substring(0, 7); //取年月
                    if (temp.equals(date)) {
                        sum += order.getQuantity();
                    }
                }
                Sales sales = new Sales();
                sales.setGoodsBrand(goodsBrand);
                sales.setOrderDate(date);
                sales.setQuantity(sum);
                salesRepository.add(sales);
                sumList.add(sum);
            }
            int predict = Predict(sumList.get(0), sumList.get(1), sumList.get(2), sumList.get(3), sumList.get(4), sumList.get(5),6);
            Sales sales = new Sales();
            sales.setGoodsBrand(goodsBrand);
            sales.setOrderDate("2019-05");
            sales.setQuantity(predict);
            salesRepository.add(sales);
        }
    }

    public void getSellerVolume() {
        List<Seller> sellerList = sellerRepository.queryAll();
        List<Integer> sellerIds = BeanUtils.extraProperty(sellerList, "sellerId");

        List<String> dateList = new ArrayList<String>();
        dateList.add("2018-11");
        dateList.add("2018-12");
        dateList.add("2019-01");
        dateList.add("2019-02");
        dateList.add("2019-03");
        dateList.add("2019-04");

        for(int sellerId : sellerIds){
            List<Goods> goodsList = goodsRepository.queryBySellerId(sellerId);
            List<Integer> goodsIds = BeanUtils.extraProperty(goodsList, "goodsId");
            for(int goodsId : goodsIds) {
                String goodsName = goodsRepository.getGoodsName(goodsId);
                List<Order> orderList = orderRepository.queryByGoodsId(goodsId);
                List<Integer> sumList = new ArrayList<Integer>();
                for (String date : dateList) {
                    //销售量
                    int sum = 0;
                    for (Order order : orderList) {
                        String str = new java.text.SimpleDateFormat("yyyy-MM-dd").format(order.getOrderDate());
                        String temp = str.substring(0, 7); //取年月
                        if (temp.equals(date)) {
                            sum += order.getQuantity();
                        }
                    }
                    SellerSales sellerSales = new SellerSales();
                    sellerSales.setSellerId(sellerId);
                    sellerSales.setGoodsName(goodsName);
                    sellerSales.setOrderDate(date);
                    sellerSales.setQuantity(sum);
                    sellerSalesRepository.add(sellerSales);
                    sumList.add(sum);
                }
                int predict = Predict(sumList.get(0), sumList.get(1), sumList.get(2), sumList.get(3), sumList.get(4), sumList.get(5), 6);
                SellerSales sellerSales = new SellerSales();
                sellerSales.setSellerId(sellerId);
                sellerSales.setGoodsName(goodsName);
                sellerSales.setOrderDate("2019-05");
                sellerSales.setQuantity(predict);
                sellerSalesRepository.add(sellerSales);
            }
        }
    }

    private int Predict(int s1, int s2, int s3, int s4, int s5, int s6, int k){
        double t1 = s1;
        double t2 = s1+s2;
        double t3 = s1+s2+s3;
        double t4 = s1+s2+s3+s4;
        double t5 = s1+s2+s3+s4+s5;
        double t6 = s1+s2+s3+s4+s5+s6;
//5/4 = 1.25   ad-bc
        double d = 1.25 * (Math.pow(t1+t2,2) + Math.pow(t2+t3,2) + Math.pow(t3+t4,2) + Math.pow(t4+t5,2) + Math.pow(t5+t6,2)) - Math.pow(t1/2 +t2+t3+t4+t5+t6/2,2);

        double w = 5 / d;
        double x = ((t1)/2 + t2 + t3 + t4 + t5 + (t6)/2) / d;
        double y = ((t1)/2 + t2 + t3 + t4 + t5 + (t6)/2) / d;
        double z = (Math.pow(t1+t2,2) + Math.pow(t2+t3,2) + Math.pow(t3+t4,2) + Math.pow(t4+t5,2) + Math.pow(t5+t6,2)) / (4*d);

        double a=(w * (-(t1+t2)/2) + x) * s2 + (w * (-(t2+t3)/2) + x) * s3 + (w * (-(t3+t4)/2) + x) * s4 + (w * (-(t4+t5)/2) + x) * s5 + (w * (-(t5+t6)/2) + x) * s6;
        double b=(y * (-(t1+t2)/2) + z) * s2 + (y * (-(t2+t3)/2) + z) * s3 + (y * (-(t3+t4)/2) + z) * s4 + (y * (-(t4+t5)/2) + z) * s5 + (y * (-(t5+t6)/2) + z) * s6;

        double pred = (s1 - b/a) * Math.pow(Math.E, -(a * k)) + b/a - t6;
        int pre = (int)pred;
        return pre;
    }

/*
        SalesVolumeDTO salesVolumeDTO = new SalesVolumeDTO();
        SalesVolume salesVolume = new SalesVolume();

        salesVolume.setSalesQuantity(sum);
        salesVolumeDTO.setSalesVolume(salesVolume);
        salesVolumeDTO.setOrderDate(orderDate);
        salesVolumeDTO.setGoodsBrand(goodsBrand);

        List<Integer> orderIds = BeanUtils.extraProperty(newOrderList,"orderId");
        if (CollectionUtils.isEmpty(orderList)) {
            return new ArrayList<SalesVolumeDTO>();
        }
        List<SalesVolume> salesVolumeList = salesVolumeRepository.findSalesVolumes(orderIds);
        return buildSalesVolume(salesVolumeList, orderList, goodsList);
*/

    private List<SalesVolumeDTO> buildSalesVolume(List<SalesVolume> salesVolumeList, List<Order> orderList, List<Goods> goodsList) {
        Map<Integer, Order> orderId2Order = BeanUtils.mapBy(orderList, "orderId");
        Map<Integer, Goods> goodsId2Goods = BeanUtils.mapBy(goodsList, "goodsId");

        List<SalesVolumeDTO> salesVolumeDTOMap = new ArrayList<SalesVolumeDTO>();
        for (SalesVolume salesVolume : salesVolumeList) {
            SalesVolumeDTO salesVolumeDTO = new SalesVolumeDTO();
            salesVolumeDTO.setSalesVolume(salesVolume);

            Order order = orderId2Order.get(salesVolume.getOrderId());
            if (order != null) {
                salesVolumeDTO.setOrderDate(order.getOrderDate());
            }

            Goods goods = goodsId2Goods.get(order.getGoodsId());
            if (goods != null) {
                salesVolumeDTO.setGoodsBrand(goods.getGoodsBrand());
            }

            salesVolumeDTOMap.add(salesVolumeDTO);
        }
        return salesVolumeDTOMap;

    }
}
