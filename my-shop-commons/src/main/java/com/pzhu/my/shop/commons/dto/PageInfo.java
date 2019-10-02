/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.commons.dto
 * @ClassName: PageInfo
 * @Author: Guo Huaijian
 * @Date: 2019/9/29 15:17
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.commons.dto;

import com.pzhu.my.shop.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/29 15:17
 * @description:分页数据传输对象
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
