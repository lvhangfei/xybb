package com.xybb.model.email;

import com.xybb.utils.EmailUtil;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by lw on 14-6-25.
 * 邮件信息bean
 */
public class Email extends HtmlEmail {

    protected static String HOST_NAME;//服务器名称

    protected static String CHARSET = "GB2312";

    static {
        HOST_NAME = EmailUtil.getValue("hostName");
        CHARSET = EmailUtil.getValue("send_charset");
    }
}


