/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.web.dto
 * @ClassName: TbContentDTO
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:47
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:47
 * @description:内容数据传输对象
 */
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
