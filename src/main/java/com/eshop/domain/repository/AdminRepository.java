package com.eshop.domain.repository;

import com.eshop.domain.model.Admin;

import org.apache.ibatis.annotations.Param;

public interface AdminRepository {
    /**
     * 添加卖家
     *
     * @param admin
     * @return
     */
    int add(@Param("admin") Admin admin);

    /**
     * 加载单个卖家
     *
     * @param adminId
     * @return
     */
    Admin load(int adminId);

    /**
     * 通过AdminName获取AdminId
     *
     * @param adminName
     * @return
     */
    int getAdminId(String adminName);

    /**
     * 获取AdminName
     *
     * @param adminId
     * @return
     */
    String getAdminName(int adminId);

    /**
     * 获取管理员密码
     *
     * @param adminName
     * @return
     */
    String getAdminPwd(String adminName);
}
