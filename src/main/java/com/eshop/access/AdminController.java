package com.eshop.access;

import com.eshop.application.AdminAppService;
import com.eshop.domain.model.Admin;
import com.eshop.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminAppService adminAppService;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminLogin");
        modelAndView.addObject("adminName", "测试用户名");
        return modelAndView;
    }

    //表单提交过来的路径
    @RequestMapping("/doLogin")
    public ModelAndView checkLogin(String adminName, String password, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法
        boolean login = adminAppService.checkLogin(adminName, password);
        //若有user则添加到model里并且跳转到成功页面
        if(login){
            LoginUtils.doLogin(response, adminName, password);
            Admin admin = adminAppService.queryAdminByName(adminName);
            modelAndView.addObject("admin", admin);
            modelAndView.setViewName("adminMessage");
            return modelAndView;
        }
        modelAndView.setViewName("fail");
        return modelAndView;
    }

    @RequestMapping("/adminMessage")
    public String adminMessage(Model model, int adminId){
        Admin admin = adminAppService.queryAdminById(adminId);
        model.addAttribute("admin", admin);
        return "adminMessage";
    }

    //注销方法
    @RequestMapping("/outAdminLogin")
    public String outAdminLogin(HttpSession session){
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "adminLogin";
    }

    @RequestMapping("/selectAdminId")
    public String selectAdminId(Model model, Integer adminId) {
        List<Admin> adminList = new ArrayList<Admin>();
        if (adminId == null) {
            //adminList = adminAppService.queryAllAdmin();
        } else {
            Admin admin = adminAppService.queryAdminById(adminId);
            if(admin != null) {
                adminList.add(admin);
            }
        }
        model.addAttribute("list", adminList);
        return "allAdmin";
    }
}
