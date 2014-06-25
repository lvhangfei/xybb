package com.xybb.model.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-25.
 * 系统管理员邮箱
 */
@Component
public class Email2Admin extends Email {

    @Value("${fromName_admin}")
    private String fromName;//发送方名称
    @Value("${fromPassword_admin}")
    private String fromPassword;//发送方密码

    public String getFromName() {
        return fromName;
    }

    public String getFromPassword() {
        return fromPassword;
    }

}
