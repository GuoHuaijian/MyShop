/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service
 * @ClassName: TbContentService
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 22:51
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.commons.dto.PageInfo;
import com.pzhu.my.shop.domain.TbContent;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 22:51
 * @description:
 */
public interface TbContentService {
    /**
     * 查询全部信息
     *
     * @param
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbUser>
     * @Date: 2019/9/23 18:48
     */
    List<TbContent> selectAll();

    /**
     * 添加
     *
     * @param tbContent
     * @Return: void
     * @Date: 2019/9/23 21:07
     */
    BaseResult save(TbContent tbContent);

    /**
     * 根据id删除单个
     *
     * @param id
     * @Return: void
     * @Date: 2019/9/23 21:07
     */
    void delete(long id);

    /**
     * 根据id查询单个
     *
     * @param id
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/23 21:08
     */
    TbContent getById(long id);

    /**
     * 修改信息
     *
     * @param tbContent
     * @Return: void
     * @Date: 2019/9/23 21:08
     */
    void update(TbContent tbContent);

    /**
     * 批量删除
     *
     * @param ids
     * @Return: void
     * @Date: 2019/9/26 0:01
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param params
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbUser>
     * @Date: 2019/9/29 11:14
     */
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    /**
     * 查询总数
     *
     * @param tbContent
     * @Return: int
     * @Date: 2019/9/29 14:42
     */
    int count(TbContent tbContent);
}
