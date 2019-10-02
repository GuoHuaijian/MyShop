/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.web.controller
 * @ClassName: ContentCategoryController
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 20:40
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.web.controller;

import com.pzhu.my.shop.domain.TbContentCategory;
import com.pzhu.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:40
 * @description:内容分类管理
 */
@Controller
@RequestMapping("content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();

        // 排序
        sortList(sourceList, targetList, 0L);
        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    /**
     * 树形结构
     *
     * @param
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbContentCategory>
     * @Date: 2019/9/30 11:15
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id) {
        if (id == null) {
            id = 0L;
        }
        return tbContentCategoryService.selectByPid(id);
    }

    /**
     * 排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId   父节点的 ID
     */
    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {
            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);

                // 判断有没有子节点，如果有则继续追加
                if (tbContentCategory.getIsParent()) {
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sortList(sourceList, targetList, tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
