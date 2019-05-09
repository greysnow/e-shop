package com.eshop.application;

import com.eshop.domain.model.User;

import java.util.List;

public interface UserAppService {
    int addUser(User user);

    int deleteUserById(int userId);

    int updateUser(User user);

    User queryUserById(int userId);

    User queryUserByName(String userName);

    List<User> queryAllUser();

    boolean checkLogin(String userName, String userPwd);
}
