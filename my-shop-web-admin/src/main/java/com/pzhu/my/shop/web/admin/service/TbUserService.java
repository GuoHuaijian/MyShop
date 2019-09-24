/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service
 * @ClassName: TbUserService
 * @Author: Guo Huaijian
 * @Date: 2019/9/23 18:51
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.domain.TbUser;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:51
 * @description:
 */
public interface TbUserService {

    /**
     * 查询用户表全部信息
     * @param
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbUser>
     * @Date: 2019/9/23 18:52
     */
    List<TbUser> selectAll();

    /**
     * 判断tbUser的id  如果id为空就调用新增的方法不为空就调用修改方法
     *
     * @param tbUser
     * @Return: void
     * @Date: 2019/9/23 21:07
     */
    BaseResult save(TbUser tbUser);

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
     * 根据名字模糊查询
     *
     * @param username
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbUser>
     * @Date: 2019/9/23 21:09
     */
    List<TbUser> selectByName(String username);

    /**
     * 登陆逻辑
     * @param email
     * @param password
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/23 21:24
     */
    TbUser login(String email,String password);

    /**
     * 根据关键字模糊查询用户
     * @param tbUser
     * @Return: java.util.List<com.pzhu.my.shop.domain.TbUser>
     * @Date: 2019/9/24 21:01
     */
    List<TbUser> search(TbUser tbUser);
}
