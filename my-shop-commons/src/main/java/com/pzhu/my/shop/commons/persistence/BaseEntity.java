/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.commons.persistence
 * @ClassName: BaseEntity
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 15:18
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 15:18
 * @description:
 */
public class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
