/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.commons.dto
 * @ClassName: BaseResult
 * @Author: Guo Huaijian
 * @Date: 2019/9/24 13:43
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.commons.dto;

import java.io.Serializable;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/24 13:43
 * @description:自定义返回结果
 */
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;

    public static BaseResult success() {
        BaseResult baseResult = BaseResult.creatBaseResult(STATUS_SUCCESS, "成功");
        return baseResult;
    }

    public static BaseResult success(String message) {
        BaseResult baseResult = BaseResult.creatBaseResult(STATUS_SUCCESS, message);
        return baseResult;
    }

    public static BaseResult fail() {
        BaseResult baseResult = BaseResult.creatBaseResult(STATUS_FAIL, "失败");
        return baseResult;
    }

    public static BaseResult fail(String message) {
        BaseResult baseResult = BaseResult.creatBaseResult(STATUS_FAIL, message);
        return baseResult;
    }

    public static BaseResult fail(int status,String message) {
        BaseResult baseResult = BaseResult.creatBaseResult(status,message);
        return baseResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BaseResult creatBaseResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }
}
