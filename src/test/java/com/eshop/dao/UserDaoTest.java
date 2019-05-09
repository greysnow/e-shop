package com.eshop.dao;

import com.eshop.domain.model.User;
import com.eshop.domain.repository.UserRepository;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testQueryAll(){
        List<User> users = userRepository.queryAll();

        System.out.print(users.size());
    }

    @Test
    public void testAdd(){
        User user = new User();

        user.setUserName("Mike");
        user.setUserPwd("123456");
        user.setUserTel("13157588233");
        user.setUserEmail("Mike@163.com");
        user.setUserAddress("上海市松江区");

        int i = userRepository.add(user);

        System.out.print(i);
    }

    @Test
    public void testDelete(){
        int userId = 2;

        int i = userRepository.delete(userId);

        System.out.print(i);
    }

    @Test
    public void testUpdate(){
        User user = new User();

        user.setUserId(1);
        user.setUserPwd("123456");
        user.setUserTel("13157588233");
        user.setUserEmail("Mike@163.com");
        user.setUserAddress("上海市松江区");

        int i = userRepository.update(user);

        System.out.print(i);
    }
    @Test
    public void testLoad(){
        int userId = 1;

        User user = userRepository.load(userId);

        System.out.print(user);

    }
    @Test
    public void testGetUserName(){
        int userId = 1;

        String str = userRepository.getUserName(userId);

        System.out.print(str);
    }
    @Test
    public void testGetUserId(){
        String userName = "A";

        int i = userRepository.getUserId(userName);

        System.out.print(i);
    }
}

