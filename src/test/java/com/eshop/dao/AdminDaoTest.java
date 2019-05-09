package com.eshop.dao;

import com.eshop.domain.model.Admin;
import com.eshop.domain.repository.AdminRepository;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminDaoTest extends BaseTest {
    @Autowired
    AdminRepository adminRepository;

    @Test
    public void testAdd() {
        Admin admin = new Admin();

        admin.setAdminName("admin");
        admin.setAdminPwd("123456");

        int i = adminRepository.add(admin);

        System.out.print(i);
    }
    @Test
    public void testLoad() {
        int adminId = 1;

        adminRepository.load(adminId);
    }
    @Test
    public void testGetAdminId(){
        String adminName = "admin";
        int i = adminRepository.getAdminId(adminName);
        System.out.print(i);
    }
    @Test
    public void testGetAdminName(){
        int adminId = 1;
        adminRepository.getAdminName(adminId);
    }
    @Test
    public void testGetAdminPwd(){
        String adminName = "admin";
        adminRepository.getAdminPwd(adminName);
    }
}