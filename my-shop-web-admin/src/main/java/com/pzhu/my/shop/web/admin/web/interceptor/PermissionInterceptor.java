/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.Interceptor
 * @ClassName: PermissionInterceptor
 * @Author: Guo Huaijian
 * @Date: 2019/9/15 20:12
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.web.interceptor;

import com.pzhu.my.shop.commons.constant.ConstantUtils;
import com.pzhu.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/15 20:12
 * @description:
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //以login结尾的请求
        if (modelAndView.getViewName().endsWith("login")) {
            TbUser user = (TbUser) request.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (user != null) {
                response.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
