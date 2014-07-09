package com.xybb.system.filter;

import com.xybb.system.parameter.SystemParameter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lw on 14-7-10.
 * 是否进行系统维护过滤器
 */
public class System_MaintenanceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        //判断是否在维护
        if (SystemParameter.IS_SYSTEM_MAINTENANCE) {
            //判断请求是否是重定向到系统维护的链接
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            if (request.getRequestURI().indexOf("system_maintenance") == -1) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("index/system_maintenance");//重定向到系统维护页面
            } else {
                chain.doFilter(servletRequest, servletResponse);
            }
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
