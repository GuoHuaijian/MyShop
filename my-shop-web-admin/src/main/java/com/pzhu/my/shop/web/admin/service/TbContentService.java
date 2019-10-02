/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service
 * @ClassName: TbContentService
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 22:51
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service;

import com.pzhu.my.shop.commons.persistence.BaseService;
import com.pzhu.my.shop.domain.TbContent;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 22:51
 * @description:
 */
public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
