package com.xybb.system.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lw on 14-6-21.
 * session 过滤器。
 * 如果设置了自动登录取cookie判断是否可以自动登录
 */
public class sessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        /*if (session.getAttribute("userName") == null) {

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
