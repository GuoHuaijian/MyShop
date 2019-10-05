/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.api
 * @ClassName: UsersApi
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:22
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.ui.api;

import com.pzhu.my.shop.commons.utils.HttpClientUtils;
import com.pzhu.my.shop.commons.utils.MapperUtils;
import com.pzhu.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:22
 * @description:会员管理接口
 */
public class UsersApi {

    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }
}
