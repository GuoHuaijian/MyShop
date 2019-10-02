/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.dao
 * @ClassName: TbContentDao
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 22:50
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.dao;

import com.pzhu.my.shop.commons.persistence.BaseDao;
import com.pzhu.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 22:50
 * @description:
 */
@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
