package com.eshop.Service;

import com.eshop.application.AdminAppService;
import com.eshop.utils.BaseTest;
import org.junit.Test;

public class AdminServiceTest extends BaseTest{
    AdminAppService adminAppService;

    @Test
    public void testQueryAdminById(){
        int adminId = 1;
        adminAppService.queryAdminById(adminId);
    }
    @Test
    public void testCheckLogin(){
        String adminName = "admin";
        String adminPwd = "123456";
        boolean check = adminAppService.checkLogin(adminName, adminPwd);
        System.out.print(check);
    }
}
