package com.eshop.application.impl;

import com.eshop.application.UserAppService;
import com.eshop.domain.model.User;
import com.eshop.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppServiceImpl implements UserAppService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public int addUser(User user) {
        return userRepository.add(user);
    }

    @Override
    public int deleteUserById(int userId) {
        return userRepository.delete(userId);
    }

    @Override
    public int updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public User queryUserById(int userId) { return userRepository.load(userId); }

    @Override
    public User queryUserByName(String userName){
        int userId = userRepository.getUserId(userName);
        return userRepository.load(userId);
    }

    @Override
    public List<User> queryAllUser() { return userRepository.queryAll(); }

    @Override
    public boolean checkLogin(String userName, String userPwd){
        if(userName == null || userPwd == null || userRepository.getUserPwd(userName) == null)
            return false;
        String userPwd1 = userRepository.getUserPwd(userName);
        if(userPwd1.equals(userPwd))
            return true;
        else
            return false;
    }
}