package com.xybb.system.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-14.
 * 系统参数
 */
@Component
public class ProjectParameter {

    public static final String READ_FILE_ENCODINGS = "utf-8";//读取文件编码

    @Value("${project.name}")
    private String projectName;//项目名称
    @Value("${project.version}")
    private String projectVersion;//项目版本号
    @Value("${project.isbeta}")
    private String projectIsBeta;//是否是测试版本

    @Value("${project.sensitivequestion.file.path}")
    private String sensitiveQuestion_File_Path;


    /*@Value("${project.home}")
    private String projectHome;//项目主页
    @Value("${project.affective}")
    private String projectAffective;//情感交流
    @Value("${project.foodie}")
    private String projectFoodie;//我是吃货
    @Value("${project.graduate}")
    private String projectGraduate;//我们毕业了
    @Value("${project.play}")
    private String projectPlay;//去哪儿玩
    @Value("${project.help}")
    private String projectHelp;//求帮助
    @Value("${project.secondhand}")
    private String projectSecondhand;//二手交易*/


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

    public String getSensitiveQuestion_File_Path() {
        return sensitiveQuestion_File_Path;
    }
}
