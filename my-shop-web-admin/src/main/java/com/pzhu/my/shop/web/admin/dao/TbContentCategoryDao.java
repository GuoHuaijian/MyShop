/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.dao
 * @ClassName: TbContentCategoryDao
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 20:38
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.dao;

import com.pzhu.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:38
 * @description:
 */
@Repository
public interface TbContentCategoryDao {

    /**
     * 内容列表
     *
     * @param
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbContentCategory>
     * @Date: 2019/9/29 21:04
     */
    List<TbContentCategory> selectAll();

    /**
     * 根据父级节点ID查询所有子节点
     *
     * @param
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbContentCategory>
     * @Date: 2019/9/30 11:09
     */
    List<TbContentCategory> selectByPid(Long Pid);
}
