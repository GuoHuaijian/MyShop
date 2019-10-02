/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.web.controller
 * @ClassName: ContentController
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 23:26
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.web.controller;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.commons.dto.PageInfo;
import com.pzhu.my.shop.domain.TbContent;
import com.pzhu.my.shop.web.admin.service.TbContentService;
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
 * @Date: 2019/9/29 23:26
 * @description:
 */
@Controller
@RequestMapping("content")
public class ContentController {

    @Autowired
    private TbContentService tbContentService;

    /**
     * 填充表单
     *
     * @param id
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/24 15:29
     */
    @ModelAttribute
    public TbContent getContent(Long id) {
        TbContent tbContent = null;
        if (id != null) {
            tbContent = tbContentService.getById(id);
        } else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 跳转列表页
     *
     * @Return: java.lang.String
     * @Date: 2019/9/24 12:44
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "content_list";
    }

    /**
     * 跳转表单页
     *
     * @param
     * @Return: java.lang.String
     * @Date: 2019/9/24 12:45
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    /**
     * 保存信息
     *
     * @param tbContent
     * @param model
     * @param redirectAttributes
     * @Return: java.lang.String
     * @Date: 2019/9/24 22:36
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentService.save(tbContent);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //重定向携带信息
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
            //保存失败
        } else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

    /**
     * 删除信息
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
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除内容成功");
        } else {
            baseResult = BaseResult.fail("删除内容失败");
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
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent) {

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);

        PageInfo<TbContent> pageInfo = tbContentService.page(start, length, draw, tbContent);
        System.out.println("测试" + pageInfo);
        return pageInfo;
    }

    /**
     * 显示详情
     *
     * @Return: java.lang.String
     * @Date: 2019/9/29 17:49
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "content_detail";
    }
}
