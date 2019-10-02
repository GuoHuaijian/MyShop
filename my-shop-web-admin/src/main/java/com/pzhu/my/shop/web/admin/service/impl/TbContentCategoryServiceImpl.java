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

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.commons.dto.PageInfo;
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
    public BaseResult save(TbContentCategory entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TbContentCategory getById(Long id) {
        return null;
    }

    @Override
    public void update(TbContentCategory entity) {

    }

    @Override
    public void deleteMulti(String[] ids) {

    }

    @Override
    public PageInfo<TbContentCategory> page(int start, int length, int draw, TbContentCategory entity) {
        return null;
    }

    @Override
    public int count(TbContentCategory entity) {
        return 0;
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }
}
