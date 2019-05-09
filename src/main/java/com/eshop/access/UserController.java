package com.eshop.access;

import com.eshop.application.UserAppService;
import com.eshop.domain.model.User;
import com.eshop.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserAppService userAppService;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userLogin");
        modelAndView.addObject("userName", "测试用户名");
        return modelAndView;
    }

    //表单提交过来的路径
    @RequestMapping("/doLogin")
    public ModelAndView checkLogin(String userName, String password, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法
        boolean login = userAppService.checkLogin(userName, password);
        //若有user则添加到model里并且跳转到成功页面
        if(login){
            LoginUtils.doLogin(response, userName, password);
            User user = userAppService.queryUserByName(userName);
            int userId = user.getUserId();
            modelAndView.addObject("user", user);
            modelAndView.addObject("userId",userId);
            modelAndView.setViewName("userMessage");
            return modelAndView;
        }
        modelAndView.setViewName("fail");
        return modelAndView;
    }

    //注销方法
    @RequestMapping("/outUserLogin")
    public String outUserLogin(HttpSession session){
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "login";
    }

    @RequestMapping("/allUser")
    public String list(Model model) {
        List<User> list = userAppService.queryAllUser();
        model.addAttribute("list", list);
        return "allUser";
    }

    @RequestMapping("toAddUser")
    public String toAddUser() {
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userAppService.addUser(user);
        return "redirect:/user/login";
    }

    @RequestMapping("/del/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        userAppService.deleteUserById(userId);
        return "redirect:/user/login";
    }

    @RequestMapping("toUpdateUser")
    public String toUpdateUser(Model model, int userId) {
        model.addAttribute("user", userAppService.queryUserById(userId));
        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Model model, int userId, String userName, String userPwd, String userEmail, String userTel, String userAddress) {
        User user = buildUser(userId, userName, userPwd, userEmail, userTel, userAddress);
        userAppService.updateUser(user);
        user = userAppService.queryUserById(user.getUserId());
        model.addAttribute("userId",userId);
        model.addAttribute("user", user);
        return "userMessage";
    }

    private User buildUser(int userId, String userName, String userPwd, String userEmail, String userTel, String userAddress) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        user.setUserEmail(userEmail);
        user.setUserTel(userTel);
        user.setUserAddress(userAddress);
        return user;
    }


    @RequestMapping("selectUserId")
    public ModelAndView selectUserId(Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = new ArrayList<User>();
        if (userId == null) {
            userList = userAppService.queryAllUser();
        } else {
            User user = userAppService.queryUserById(userId);
            if(user != null) {
                userList.add(user);
            }
        }
        modelAndView.addObject("list", userList);
        modelAndView.setViewName("allUser");
        return modelAndView;
    }
}
