/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.service.impl
 * @ClassName: TbContentServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:42
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.service.impl;

import com.pzhu.my.shop.domain.TbContent;
import com.pzhu.my.shop.domain.TbContentCategory;
import com.pzhu.my.shop.web.api.dao.TbContentDao;
import com.pzhu.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:42
 * @description:
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);

        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);

        return tbContentDao.selectByCategoryId(tbContent);
    }
}
