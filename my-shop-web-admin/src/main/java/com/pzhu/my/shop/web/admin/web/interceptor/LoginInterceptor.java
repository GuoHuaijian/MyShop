/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.Interceptor
 * @ClassName: LoginInterceptor
 * @Author: Guo Huaijian
 * @Date: 2019/9/15 18:27
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
 * @Date: 2019/9/15 18:27
 * @description:登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbUser user = (TbUser) request.getSession().getAttribute(ConstantUtils.SESSION_USER);

        //未登录
        if (user == null) {
            response.sendRedirect("/login");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
