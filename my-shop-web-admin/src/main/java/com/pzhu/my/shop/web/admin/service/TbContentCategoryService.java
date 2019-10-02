/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service
 * @ClassName: TbContentCategoryService
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 20:39
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service;

import com.pzhu.my.shop.commons.persistence.BaseService;
import com.pzhu.my.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:39
 * @description:
 */
public interface TbContentCategoryService extends BaseService<TbContentCategory> {
    /**
     * 根据父级节点ID查询所有子节点
     *
     * @param pid
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbContentCategory>
     * @Date: 2019/9/30 11:09
     */
    List<TbContentCategory> selectByPid(Long pid);
}
