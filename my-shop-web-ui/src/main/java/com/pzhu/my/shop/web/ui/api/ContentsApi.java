/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.api
 * @ClassName: ContentsApi
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:22
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.ui.api;

import com.pzhu.my.shop.commons.utils.HttpClientUtils;
import com.pzhu.my.shop.commons.utils.MapperUtils;
import com.pzhu.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:22
 * @description:内容管理接口
 */
public class ContentsApi {

    /**
     * 请求幻灯片
     *
     * @return
     */
    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
