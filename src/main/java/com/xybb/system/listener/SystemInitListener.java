package com.xybb.system.listener;

import com.xybb.system.parameter.ProjectParameter;
import com.xybb.system.parameter.SensitiveQuestion;
import com.xybb.system.parameter.SystemParameter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

/**
 * Created by lw on 14-6-15.
 * 启动监听
 * 参数初始化
 */

public class SystemInitListener implements ServletContextListener {

    //DEBUG,mecachedLog,esLog,quartzLog
    private static final Logger MECACHEDLOG = Logger.getLogger("mecachedLog");
    private static final Logger ESLOG = Logger.getLogger("esLog");
    private static final Logger QUARTZLOG = Logger.getLogger("quartzLog");
    private static final Log LOG = LogFactory.getLog(SystemInitListener.class);

    private WebApplicationContext applicationContext;
    private ServletContext context;
    private ProjectParameter projectParameter;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        this.context = applicationContext.getServletContext();
        ProjectParameter.APPLICATIONCONTEXT_PATH = context.getRealPath("/");
        projectParameter = (ProjectParameter) applicationContext.getBean("projectParameter");
        initProjectMessage();
        initSensitiveQuestion();
        MECACHEDLOG.info("mecachedLog");
        ESLOG.info("esLog");
        QUARTZLOG.info("quartzLog");
        LOG.info("LOG");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /**
     * 初始化系统参数信息
     */
    private void initProjectMessage() {
        context.setAttribute("PROJECTNAME", projectParameter.getProjectName());
        context.setAttribute("PROJECTVERSION", projectParameter.getProjectVersion());
        context.setAttribute("PROJECTISBETA", projectParameter.getProjectIsBeta());
    }

    /**
     * 初始化敏感字信息
     */
    private void initSensitiveQuestion() {
        String file_path = ProjectParameter.APPLICATIONCONTEXT_PATH + SystemParameter.FILE_SEPARATOR + "WEB-INF/classes/" +
                projectParameter.getSensitiveQuestion_File_Path();
        File file = new File(file_path);
        try {
            SensitiveQuestion.SENSITIVEQUESTIONS = FileUtils.readLines(file, ProjectParameter.READ_FILE_ENCODINGS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
