/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service.impl
 * @ClassName: TbContentCategoryServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 20:39
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service.impl;

import com.pzhu.my.shop.domain.TbContentCategory;
import com.pzhu.my.shop.web.admin.dao.TbContentCategoryDao;
import com.pzhu.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:39
 * @description:
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }
}
