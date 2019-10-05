/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.dao
 * @ClassName: TbContentDao
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:40
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.dao;

import com.pzhu.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:40
 * @description:
 */
@Repository
public interface TbContentDao {
    /**
     * 根据类别 ID 查询内容列表
     *
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
