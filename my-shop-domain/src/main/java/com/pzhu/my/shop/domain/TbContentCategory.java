/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.domain
 * @ClassName: TbContentCategory
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 20:27
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pzhu.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:27
 * @description:
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
}


