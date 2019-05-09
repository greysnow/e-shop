package com.eshop.application.impl;

import com.eshop.domain.model.Seller;
import com.eshop.domain.repository.SellerRepository;
import com.eshop.application.SellerAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerAppServiceImpl implements SellerAppService {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public int addSeller(Seller seller) {
        return sellerRepository.add(seller);
    }

    @Override
    public int deleteSellerById(int sellerId) {
        return sellerRepository.delete(sellerId);
    }

    @Override
    public int updateSeller(Seller seller) {
        return sellerRepository.update(seller);
    }

    @Override
    public Seller querySellerById(int sellerId) {
        return sellerRepository.load(sellerId);
    }

    @Override
    public Seller querySellerByName(String sellerName){
        int sellerId = sellerRepository.getSellerId(sellerName);
        return sellerRepository.load(sellerId);

    }

    @Override
    public List<Seller> queryAllSeller() { return sellerRepository.queryAll(); }

    @Override
    public boolean checkLogin(String sellerName, String sellerPwd){
        if(sellerName == null || sellerPwd == null || sellerRepository.getSellerPwd(sellerName) == null)
            return false;
        String sellerPwd1 = sellerRepository.getSellerPwd(sellerName);
        if(sellerPwd1.equals(sellerPwd))
            return true;
        else
            return false;
    }

}