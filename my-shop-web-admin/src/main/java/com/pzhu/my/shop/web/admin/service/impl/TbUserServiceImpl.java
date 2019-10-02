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
import com.pzhu.my.shop.commons.dto.PageInfo;
import com.pzhu.my.shop.commons.validator.BeanValidator;
import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.admin.dao.TbUserDao;
import com.pzhu.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null) {
                tbUser.setCreated(new Date());
                //密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUserDao.insert(tbUser);
                //修改用户
            } else {
                tbUserDao.update(tbUser);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }


    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
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
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser) {
        int count = tbUserDao.count(tbUser);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbUser",tbUser);

        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

//    /**
//     * 用户信息的有效性验证
//     *
//     * @param tbUser
//     * @Return: void
//     * @Date: 2019/9/24 14:04
//     */
//    public BaseResult checkTbUser(TbUser tbUser) {
//        BaseResult baseResult = BaseResult.success();
//        //非空验证
//        if (StringUtils.isBlank(tbUser.getEmail())) {
//            baseResult = BaseResult.fail("邮箱不能为空，请重新输入！");
//        } else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
//            baseResult = BaseResult.fail("邮箱格式不对，请重新输入！");
//        } else if (StringUtils.isBlank(tbUser.getPassword())) {
//            baseResult = BaseResult.fail("密码不能为空，请重新输入！");
//        } else if (StringUtils.isBlank(tbUser.getUsername())) {
//            baseResult = BaseResult.fail("姓名不能为空，请重新输入！");
//        } else if (StringUtils.isBlank(tbUser.getPhone())) {
//            baseResult = BaseResult.fail("手机号不能为空，请重新输入！");
//        } else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
//            baseResult = BaseResult.fail("手机号格式不对，请重新输入！");
//        }
//        return baseResult;
//    }
}
