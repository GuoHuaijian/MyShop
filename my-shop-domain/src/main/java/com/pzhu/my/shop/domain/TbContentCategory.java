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
import com.pzhu.my.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 20:27
 * @description:
 */
@Data
public class TbContentCategory extends BaseTreeEntity {
    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
    private TbContentCategory parent;
}


