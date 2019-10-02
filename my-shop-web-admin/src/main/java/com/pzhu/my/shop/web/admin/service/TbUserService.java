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

import com.pzhu.my.shop.commons.persistence.BaseService;
import com.pzhu.my.shop.domain.TbUser;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:51
 * @description:
 */
public interface TbUserService extends BaseService<TbUser> {
    /**
     * 登陆逻辑
     *
     * @param email
     * @param password
     * @Return: com.pzhu.my.shop.domain.TbUser
     * @Date: 2019/9/23 21:24
     */
    TbUser login(String email, String password);
}
