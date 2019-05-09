package com.eshop.domain.repository;

import com.eshop.domain.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRepository {
    /**
     * 新增顾客
     *
     * @param user
     * @return
     */
    int add(@Param("user") User user);

    /**
     * 删除User
     *
     * @param userId
     * @return
     */
    int delete(@Param("userId") int userId);

    /**
     * 更新User
     *
     * @param user
     * @return
     */
    int update(@Param("user") User user);

    /**
     * 加载单个顾客
     *
     * @param userId
     * @return
     */
    User load(int userId);

    /**
     * 查询所有的顾客
     *
     * @return
     */
    List<User> queryAll();

    /**
     * 通过UserName获取UserId
     *
     * @param userName
     * @return
     */
    int getUserId(String userName);

    /**
     * 获取UserName
     *
     * @param userId
     * @return
     */
    String getUserName(int userId);

    /**
     * 获取用户密码
     *
     * @param userName
     * @return
     */
    String getUserPwd(String userName);

    /**
     * 根据UsersID列表批量查询User列表
     * @param userIds
     * @return
     */
    List<User> findUsers(@Param("userIds") List<Integer> userIds);
}
