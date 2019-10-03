/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.dao
 * @ClassName: TbContentCategoryDao
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 20:38
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.dao;

import com.pzhu.my.shop.commons.persistence.BaseTreeDao;
import com.pzhu.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:38
 * @description:
 */
@Repository
public interface TbContentCategoryDao extends BaseTreeDao<TbContentCategory> {

}
