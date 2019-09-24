/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service.impl
 * @ClassName: TbUserServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/9/23 18:53
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service.impl;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.commons.utils.RegexpUtils;
import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.admin.dao.TbUserDao;
import com.pzhu.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:53
 * @description:
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdate(new Date());
            //修改用户
            if (tbUser.getId() == null) {
                tbUser.setCreated(new Date());
                //密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUserDao.insert(tbUser);
                //修改用户
            } else {
                tbUserDao.update(tbUser);
            }
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByName(String username) {
        return tbUserDao.selectByName(username);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            //明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密的密码与数据库存储的是否一样，一样则允许登陆
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {
        List<TbUser> tbUsers = tbUserDao.search(tbUser);
        return tbUsers;
    }

    /**
     * 用户信息的有效性验证
     *
     * @param tbUser
     * @Return: void
     * @Date: 2019/9/24 14:04
     */
    public BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入！");
        } else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不对，请重新输入！");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新输入！");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空，请重新输入！");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空，请重新输入！");
        } else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号格式不对，请重新输入！");
        }
        return baseResult;
    }
}
