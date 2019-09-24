/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.web.controller
 * @ClassName: LoginController
 * @Author: Guo Huaijian
 * @Date: 2019/9/17 0:27
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.web.controller;

import com.pzhu.my.shop.commons.constant.ConstantUtils;
import com.pzhu.my.shop.commons.utils.CookieUtils;
import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: Guo Huaijian
 * @Date: 2019/9/17 0:27
 * @description:
 */
@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登陆页面
     *
     * @param
     * @Return: java.lang.String
     * @Date: 2019/9/15 18:21
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest req) {
        String userInfo = CookieUtils.getCookieValue(req, ConstantUtils.COOKIE_NAME_USER_INFO);
        //判断cookie是否为空，不为空就将cookie中保存的邮箱和密码传给前端通过el表达式回填进表单
        if (StringUtils.isNotBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("isRemember", true);
        }
        return "login";
    }

    /**
     * 登陆逻辑
     *
     * @param email
     * @param password
     * @Return: java.lang.String
     * @Date: 2019/9/15 18:21
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password,
                        String isRemember, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String isRemembers = isRemember;
        boolean Remember = isRemembers == null ? false : true;
        TbUser user = tbUserService.login(email, password);

        //不记住密码就删除cookie信息
        if (!Remember) {
            CookieUtils.deleteCookie(httpServletRequest, httpServletResponse, ConstantUtils.COOKIE_NAME_USER_INFO);
        }

        //登陆成功
        if (user != null) {
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            if (Remember) {
                //用户信息存储一周，String.format("%s;%s",email,password)格式化，这样拼接可以节约内存
                CookieUtils.setCookie(httpServletRequest,httpServletResponse, ConstantUtils.COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }
            return "redirect:/main";
            //登陆失败
        } else {
            httpServletRequest.setAttribute("message", "账号或密码错误");
            return login(httpServletRequest);
        }
    }

    /**
     * 注销
     *
     * @param httpServletRequest
     * @Return: java.lang.String
     * @Date: 2019/9/17 12:36
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return login(httpServletRequest);
    }
}
