/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.dto
 * @ClassName: TbUser
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
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
