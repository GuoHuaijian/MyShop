/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.api
 * @ClassName: API
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:21
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.ui.api;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:21
 * @description:
 */
public class API {
    // 主机地址
    public static final String HOST = "http://localhost:8081/api/v1";

    // 内容查询接口 - 幻灯片
    public static final String API_CONTENTS_PPT = HOST + "/contents/ppt";

    // 会员管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/users/login";
}
