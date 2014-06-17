package com.xybb.system.systeminit;

import com.xybb.system.parameter.ProjectParameter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lw on 14-6-15.
 * 启动监听
 * 参数初始化
 */

public class StartForRecoveryListener implements ServletContextListener {

    private WebApplicationContext applicationContext;
    private ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        this.context = applicationContext.getServletContext();
        initProjectMessage();


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /**
     * 初始化系统参数信息
     */
    private void initProjectMessage() {
        ProjectParameter projectParameter = (ProjectParameter) applicationContext.getBean("projectParameter");
        context.setAttribute("PROJECTNAME", projectParameter.getProjectName());
        context.setAttribute("PROJECTVERSION", projectParameter.getProjectVersion());
        context.setAttribute("PROJECTISBETA", projectParameter.getProjectIsBeta());
    }
}
