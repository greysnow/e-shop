package com.eshop.application;

import com.eshop.domain.model.Seller;

import java.util.List;

public interface SellerAppService {
    int addSeller(Seller seller);

    int deleteSellerById(int sellerId);

    int updateSeller(Seller seller);

    Seller querySellerById(int sellerId);

    Seller querySellerByName(String sellerName);

    List<Seller> queryAllSeller();

    boolean checkLogin(String sellerName, String sellerPwd);
}
