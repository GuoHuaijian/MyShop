/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.service
 * @ClassName: TbContentService
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:41
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.service;

import com.pzhu.my.shop.domain.TbContent;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:41
 * @description:
 */
public interface TbContentService {
    /**
     * 根据类别 ID 查询内容列表
     *
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
