/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.domain
 * @ClassName: TbUser
 * @Author: Guo Huaijian
 * @Date: 2019/9/23 18:42
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pzhu.my.shop.commons.persistence.BaseEntity;
import com.pzhu.my.shop.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:42
 * @description:
 */
@Data
public class TbUser extends BaseEntity {
    @Length(min = 6, max = 20, message = "姓名的长度必须介于 6 - 20 位之间")
    private String username;
    @JsonIgnore//不封装进json
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
}
