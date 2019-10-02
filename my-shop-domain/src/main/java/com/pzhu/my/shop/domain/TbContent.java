/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.domain
 * @ClassName: TbContent
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 22:46
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.domain;

import com.pzhu.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 22:46
 * @description:内容管理
 */
@Data
public class TbContent extends BaseEntity {
    private String categoryId;
    @Length(min = 1, max = 20, message = "标题长度介于 1 - 20 个字符之间")
    private String title;
    @Length(min = 1, max = 20, message = "子标题长度介于 1 - 20 个字符之间")
    private String subTitle;
    @Length(min = 1, max = 50, message = "标题描述长度介于 1 - 50 个字符之间")
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    @Length(min = 1, message = "内容不能为空")
    private String content;
}
