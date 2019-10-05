/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.dto
 * @ClassName: TbContent
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:24
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:24
 * @description:
 */
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
