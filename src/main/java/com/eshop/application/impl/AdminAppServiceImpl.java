package com.eshop.application.impl;

import com.eshop.domain.model.Admin;
import com.eshop.domain.repository.AdminRepository;
import com.eshop.application.AdminAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminAppServiceImpl implements AdminAppService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin queryAdminById(int adminId) { return adminRepository.load(adminId); }

    @Override
    public Admin queryAdminByName(String adminName){
        int adminId = adminRepository.getAdminId(adminName);
        return adminRepository.load(adminId);
    }

    @Override
    public boolean checkLogin(String adminName, String adminPwd){
        if(adminName == null || adminPwd == null || adminRepository.getAdminPwd(adminName) == null)
            return false;
        String adminPwd1 = adminRepository.getAdminPwd(adminName);
        if(adminPwd1.equals(adminPwd))
            return true;
        else
            return false;
    }
}