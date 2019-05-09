package com.eshop.application;

import com.eshop.domain.model.Admin;

public interface AdminAppService {
    Admin queryAdminById(int adminId);

    Admin queryAdminByName(String adminName);

    boolean checkLogin(String adminName, String adminPwd);
}
