/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.commons.persistence
 * @ClassName: BaseTreeEntity
 * @Author: Guo Huaijian
 * @Date: 2019/10/3 9:50
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/3 9:50
 * @description:
 */
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
