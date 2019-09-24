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

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 18:42
 * @description:
 */
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date update;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }
}
