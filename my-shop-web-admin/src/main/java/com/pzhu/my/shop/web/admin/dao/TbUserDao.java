/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.dao
 * @ClassName: TbUserDao
 * @Author: Guo Huaijian
 * @Date: 2019/9/23 18:47
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.dao;

import com.pzhu.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:47
 * @description:
 */

@Repository
public interface TbUserDao {

    /**
     * 查询用户表全部信息
     *
     * @param
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbUser>
     * @Date: 2019/9/23 18:48
     */
    List<TbUser> selectAll();

    /**
     * 添加用户
     *
     * @param tbUser
     * @Return: void
     * @Date: 2019/9/23 21:07
     */
    void insert(TbUser tbUser);

    /**
     * 根据id删除单个用户
     *
     * @param id
     * @Return: void
     * @Date: 2019/9/23 21:07
     */
    void delete(long id);

    /**
     * 根据id查询单个用户
     *
     * @param id
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/23 21:08
     */
    TbUser getById(long id);

    /**
     * 修改用户信息
     *
     * @param tbUser
     * @Return: void
     * @Date: 2019/9/23 21:08
     */
    void update(TbUser tbUser);

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/23 21:14
     */
    TbUser getByEmail(String email);

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
    List<TbUser> page(Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param tbUser
     * @Return: int
     * @Date: 2019/9/29 14:42
     */
    int count(TbUser tbUser);
}
