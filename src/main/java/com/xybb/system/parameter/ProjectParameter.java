package com.xybb.system.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-14.
 * 系统参数
 */
@Component
public class ProjectParameter {

    @Value("${project.name}")
    private String projectName;//项目名称
    @Value("${project.version}")
    private String projectVersion;//项目版本号
    @Value("${project.isbeta}")
    private String projectIsBeta;//是否是测试版本

    private ProjectParameter() {

    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public String getProjectIsBeta() {
        return projectIsBeta;
    }
}
