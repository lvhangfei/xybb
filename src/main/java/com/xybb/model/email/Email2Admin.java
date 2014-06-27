package com.xybb.model.email;

import com.xybb.system.parameter.ProjectParameter;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-25.
 * 系统管理员邮箱
 */
@Component
public class Email2Admin extends Email {

    @Value("${fromEmailName_admin}")
    private String fromEmailName;//发送方email名称
    @Value("${project.name}")
    private String fromName;//发送方email别名
    @Value("${fromEmailPassword_admin}")
    private String fromPassword;//发送方密码

    @Override
    public void setAuthentication(String userName, String password) {
        super.setAuthentication(this.fromName, this.fromPassword);
    }

    @Override
    public org.apache.commons.mail.Email setFrom(String email, String name, String charset) throws EmailException {
        return super.setFrom(this.fromEmailName, this.fromName, ProjectParameter.APPLICATIONCONTEXT_PATH);
    }
}
