package com.xybb.system.filter;

import com.xybb.model.user.Session2UserInfo;
import com.xybb.model.user.UserInfo;
import com.xybb.mvc.repository.UserInfoRository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lw on 14-6-21.
 * session 过滤器。
 * 如果设置了自动登录取cookie判断是否可以自动登录
 */
public class SessionFilter implements Filter {

    private UserInfoRository userInfoRository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        userInfoRository = (UserInfoRository) applicationContext.getBean("userInfoRository");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        //用户自动登录
        if (null == session.getAttribute("session2UserInfo")) {
            Cookie[] cookies = request.getCookies();
            if (null != cookies) {
                for (Cookie cookie : cookies) {
                    if (StringUtils.equals(cookie.getName(), "_xybb_auth_record")) {
                        UserInfo userInfo = userInfoRository.getUserByCookie(cookie.getValue());
                        if (null != userInfo) {
                            request.getSession().setAttribute("session2UserInfo", Session2UserInfo.getSession2UserInfo(userInfo));
                        }
                        break;
                    }
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
