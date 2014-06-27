package com.xybb.model.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lw on 14-6-25.
 * 邮件信息bean
 */
public abstract class Email extends HtmlEmail {

    @Value("${hostName}")
    private String hostName;//服务器名称

    private static final String CHARSET = "GB2312";

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public void setCharset(String newCharset) {
        super.setCharset(CHARSET);
    }
}
