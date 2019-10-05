/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.dao
 * @ClassName: TbUserDao
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:40
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.dao;

import com.pzhu.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:40
 * @description:
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
