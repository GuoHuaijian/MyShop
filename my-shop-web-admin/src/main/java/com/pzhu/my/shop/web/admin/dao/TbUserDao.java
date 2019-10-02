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

import com.pzhu.my.shop.commons.persistence.BaseDao;
import com.pzhu.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:47
 * @description:
 */

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
