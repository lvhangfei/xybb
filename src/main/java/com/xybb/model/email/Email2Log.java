package com.xybb.model.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-25.
 * 系统日志管理邮箱
 */
@Component
public class Email2Log extends Email {

    @Value("${fromEmailName_log}")
    private String fromEmailName;//发送方email名称
    @Value("${project.name}" + "_Log")
    private String fromName;//发送方email别名
    @Value("${fromEmailPassword_log}")
    private String fromPassword;//发送方密码

    public String getFromEmailName() {
        return fromEmailName;
    }

    public String getFromName() {
        return fromName;
    }

    public String getFromPassword() {
        return fromPassword;
    }
}
