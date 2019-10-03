/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.commons.persistence
 * @ClassName: BaseTreeService
 * @Author: Guo Huaijian
 * @Date: 2019/10/3 9:54
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.commons.persistence;

import com.pzhu.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/3 9:54
 * @description:通用的树形结构接口
 */
public interface BaseTreeService<T extends BaseEntity> {
    /**
     * 查询全部数据
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     *
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 查询信息
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
