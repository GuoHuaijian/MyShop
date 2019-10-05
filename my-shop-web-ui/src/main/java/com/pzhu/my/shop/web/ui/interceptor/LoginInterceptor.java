/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.ui.interceptor
 * @ClassName: LoginInterceptor
 * @Author: Guo Huaijian
 * @Date: 2019/10/5 15:25
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.ui.interceptor;

import com.pzhu.my.shop.web.ui.constant.SystemConstants;
import com.pzhu.my.shop.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Guo Huaijian
 * @Date: 2019/10/5 15:25
 * @description:
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbUser tbUser = (TbUser) request.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);

        // 未登录状态
        if (tbUser == null) {
            return true;
        }

        // 已登录状态
        else {
            response.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
