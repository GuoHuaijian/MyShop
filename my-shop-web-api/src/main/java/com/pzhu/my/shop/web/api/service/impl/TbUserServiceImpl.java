/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.service.impl
 * @ClassName: TbUserServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:44
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.service.impl;

import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.api.dao.TbUserDao;
import com.pzhu.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:44
 * @description:
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if (user != null) {
            // 将明文密码加密
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
