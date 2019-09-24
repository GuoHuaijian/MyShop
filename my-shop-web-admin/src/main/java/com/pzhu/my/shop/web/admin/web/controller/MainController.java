/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.web.controller
 * @ClassName: MainController
 * @Author: Guo Huaijian
 * @Date: 2019/9/17 0:28
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/17 0:28
 * @description:
 */
@Controller
public class MainController {

    /**
     * 跳转到主页
     *
     * @param
     * @Return: java.lang.String
     * @Date: 2019/9/15 18:19
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
