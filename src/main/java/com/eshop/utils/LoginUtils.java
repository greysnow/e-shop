package com.eshop.utils;

import com.eshop.application.UserAppService;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆工具，包括如下工具方法：
 * <pre>
 *     1、设置用于登陆cookie
 *     2、清空用户登陆态
 *     3、校验当前请求是否处于登陆态
 * </pre>
 */
public class LoginUtils {

    /**
     * 在cookie中存放用户名所使用的key
     */
    private static String USER_NAME_COOKIE_KEY = "_u";

    /**
     * 在cookie中存放密码所使用的key
     */
    private static String PASSWORD_COOKIE_KEY = "_p";

    /**
     * cookie 有效期为30分钟
     */
    private static int COOKIE_MAX_AGE = 60 * 60;

    private static UserAppService userAppService;

    @Resource
    public void setUserAppService(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    /**
     * 用于登陆
     * @param response
     * @param userName
     * @param pwd
     */
    public static void doLogin(HttpServletResponse response, String userName, String pwd) {
        Cookie userNameCookie = new Cookie(USER_NAME_COOKIE_KEY, userName);
        userNameCookie.setMaxAge(COOKIE_MAX_AGE);
        userNameCookie.setPath("/");
        response.addCookie(userNameCookie);

        Cookie passwordCookie = new Cookie(PASSWORD_COOKIE_KEY, pwd);
        passwordCookie.setMaxAge(COOKIE_MAX_AGE);
        passwordCookie.setPath("/");
        response.addCookie(passwordCookie);
    }


    /**
     * 用于登出、清空cookie
     * @param request
     */
    public static void doLoginOut(HttpServletRequest request) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null) {
            return;
        }
        for (Cookie cookie : cookieList) {
            if (USER_NAME_COOKIE_KEY.equals(cookie.getName())
                    || PASSWORD_COOKIE_KEY.equals(cookie.getName())) {
                cookie.setValue(StringUtils.EMPTY);
            }
        }
    }

    /**
     * 用于校验请求是否处于登陆态
     * @param request
     * @return
     */
    public static boolean checkLogin(HttpServletRequest request) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null) {
            return false;
        }
        String userName = StringUtils.EMPTY;
        String password = StringUtils.EMPTY;
        for (Cookie cookie : cookieList) {
            if (USER_NAME_COOKIE_KEY.equals(cookie.getName())) {
                userName = cookie.getValue();
            }
            if (PASSWORD_COOKIE_KEY.equals(cookie.getName())) {
                password = cookie.getValue();
            }
        }
        return userAppService.checkLogin(userName, password);
    }

}
