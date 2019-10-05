/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.controller
 * @ClassName: RegisterController
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:29
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:29
 * @description:注册控制器
 */
@Controller
public class RegisterController {
    /**
     * 跳转注册页
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}
