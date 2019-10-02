/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service.impl
 * @ClassName: TbContentServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 22:51
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service.impl;

import com.pzhu.my.shop.commons.dto.BaseResult;
import com.pzhu.my.shop.commons.dto.PageInfo;
import com.pzhu.my.shop.commons.validator.BeanValidator;
import com.pzhu.my.shop.domain.TbContent;
import com.pzhu.my.shop.web.admin.dao.TbContentDao;
import com.pzhu.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 22:51
 * @description:
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            tbContent.setUpdated(new Date());
            //新增用户
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
                //修改用户
            } else {
                tbContentDao.update(tbContent);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent) {
        int count = tbContentDao.count(tbContent);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("tbContent", tbContent);

        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(params));

        return pageInfo;
    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

    @Override
    public void deleteByCategoryId(String[] categoryIds) {
        tbContentDao.deleteByCategoryId(categoryIds);
    }

//    /**
//     * 用户信息的有效性验证
//     *
//     * @param tbContent
//     * @Return: void
//     * @Date: 2019/9/24 14:04
//     */
//    public BaseResult checkTbContent(TbContent tbContent) {
//        BaseResult baseResult = BaseResult.success();
//        //非空验证
//        if (StringUtils.isBlank(tbContent.getCategoryId())) {
//            baseResult = BaseResult.fail("内容所属分类不能为空，请重新输入！");
//        }
//        return baseResult;
//    }
}
