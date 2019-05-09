package com.eshop.Service;

import com.eshop.application.UserAppService;
import com.eshop.domain.model.User;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    UserAppService userAppService;

    @Test
    public void testAddUser(){
        User user = new User();

        user.setUserName("Mike");
        user.setUserPwd("123456");
        user.setUserTel("13337588233");
        user.setUserEmail("Mike@163.com");
        user.setUserAddress("上海市松江区");

        userAppService.addUser(user);
    }
    @Test
    public void testDeleteUserById(){
        int userId = 2;
        userAppService.deleteUserById(userId);
    }
    @Test
    public void testUpdateUser(){
        User user = new User();

        user.setUserId(1);
        user.setUserPwd("123456");
        user.setUserTel("13157588233");
        user.setUserEmail("Mike@163.com");
        user.setUserAddress("上海市松江区");

        int i = userAppService.updateUser(user);
        System.out.print(i);
    }

    @Test
    public void testQueryByUserId() {
        int userId = 1;
        User user = userAppService.queryUserById(userId);
        System.out.print(user);
    }
}