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
import com.pzhu.my.shop.commons.dto.PageInfo;
import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

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
     * @Return: java.lang.String
     * @Date: 2019/9/24 12:44
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
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
     * 删除用户信息
     *
     * @param ids
     * @Return: com.pzhu.my.shop.commons.dto.BaseResult
     * @Date: 2019/9/25 22:46
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;
    }

    /**
     * 分页查询
     *
     * @param
     * @Return: com.pzhu.my.shop.commons.dto.BaseResult
     * @Date: 2019/9/29 14:34
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser) {

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);

        PageInfo<TbUser> pageInfo = tbUserService.page(start, length, draw,tbUser);
        System.out.println(pageInfo);
        return pageInfo;
    }

    /**
     * 显示用户详情
     *
     * @Return: java.lang.String
     * @Date: 2019/9/29 17:49
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "user_detail";
    }
}
