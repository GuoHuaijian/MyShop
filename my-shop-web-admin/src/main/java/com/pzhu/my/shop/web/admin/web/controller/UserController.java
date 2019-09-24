/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.web.controller
 * @ClassName: UserController
 * @Author: Guo Huaijian
 * @Date: 2019/9/24 10:41
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.web.controller;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/24 10:41
 * @description:
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 填充表单
     *
     * @param id
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/24 15:29
     */
    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        if (id != null) {
            tbUser = tbUserService.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转用户列表页
     *
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/9/24 12:44
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    /**
     * 跳转用户表单页
     *
     * @param
     * @Return: java.lang.String
     * @Date: 2019/9/24 12:45
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @param model
     * @param redirectAttributes
     * @Return: java.lang.String
     * @Date: 2019/9/24 22:36
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbUserService.save(tbUser);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //重定向携带信息
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
            //保存失败
        } else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }

    /**
     * 搜索
     *
     * @param tbUser
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/9/24 21:12
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(TbUser tbUser, Model model) {
        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }
}
