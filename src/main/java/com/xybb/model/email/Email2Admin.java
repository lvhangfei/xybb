package com.xybb.model.email;

import com.xybb.utils.EmailUtil;
import org.apache.commons.mail.EmailException;


/**
 * Created by lw on 14-6-25.
 * 系统管理员邮箱
 */
public class Email2Admin extends Email {

    public static String FROM_EMAILNAME;//发送方email名称
    public static String FROM_NAME;//发送方email别名
    public static String FROM_PASSWORD;//发送方密码

    static {
        FROM_EMAILNAME = EmailUtil.getValue("fromEmailName_admin");
        FROM_PASSWORD = EmailUtil.getValue("fromEmailPassword_admin");
        FROM_NAME = EmailUtil.getValue("fromName_admin");
    }

    /**
     * 初始化 邮件发送信息
     *
     * @return 初始化后的邮件发送信息
     * @throws EmailException
     */
    public static Email2Admin getEmail2Admin() throws EmailException {
        Email2Admin email2Admin = new Email2Admin();
        email2Admin.setCharset(CHARSET);
        email2Admin.setHostName(HOST_NAME);
        email2Admin.setAuthentication(FROM_EMAILNAME, FROM_PASSWORD);
        email2Admin.setFrom(FROM_EMAILNAME, FROM_NAME);
        return email2Admin;
    }

}
