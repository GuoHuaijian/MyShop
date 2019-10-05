/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.service
 * @ClassName: TbUserService
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:41
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.service;

import com.pzhu.my.shop.domain.TbUser;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:41
 * @description:
 */
public interface TbUserService {
    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
