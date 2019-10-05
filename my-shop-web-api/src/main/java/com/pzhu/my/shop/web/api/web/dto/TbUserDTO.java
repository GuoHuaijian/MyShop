/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.api.web.dto
 * @ClassName: TbUserDTO
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 13:48
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 13:48
 * @description:会员数据传输对象
 */
@Data
public class TbUserDTO implements Serializable {
    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
