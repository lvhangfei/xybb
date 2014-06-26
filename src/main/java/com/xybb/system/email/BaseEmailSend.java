package com.xybb.system.email;

import org.apache.commons.mail.*;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by lw on 14-6-25.
 * 邮件发送demo
 */
public class BaseEmailSend {

    public BaseEmailSend() {

    }

    /**
     * SimpleEmail
     * 简单邮件发送
     */
    public static void sendSimpleEmail() {
        SimpleEmail email = new SimpleEmail();
        //email.setTLS(true); //是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验
        email.setDebug(true);
        //email.setSSL(true);
        email.setHostName("smtp.163.com");
        email.setAuthenticator(new DefaultAuthenticator("xybb_admin@163.com", "xybb_admin_liwei"));
        try {

            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            //绝对路径
            attachment.setPath("/Users/lw/Desktop/11.jpg");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Picture of John");
            attachment.setName("John");

            email.setFrom("xybb_admin@163.com", "校园帮帮"); //发送方,这里可以写多个
            email.addTo("liweityut@163.com", "xiaohulu"); // 接收方
            email.addCc("402******@qq.com"); // 抄送方
            email.addBcc("yuaio@163.com"); // 秘密抄送方
            email.setCharset("GB2312");
            email.setSubject("标题哦"); // 标题
            email.setMsg("测试测试内容，请查阅！！！");// 内容
            email.send();

            System.out.println("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    /**
     * MultiPartEmail
     * 带附件邮件发送
     */
    public static void sendMultiPartEmail() {
        MultiPartEmail email = new MultiPartEmail();
        //email.setTLS(true); //是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验
        email.setDebug(true);
        //email.setSSL(true);
        email.setHostName("smtp.163.com");
        email.setAuthenticator(new DefaultAuthenticator("xybb_admin@163.com", "xybb_admin_liwei"));
        try {

            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            //绝对路径
            attachment.setPath("/Users/lw/Desktop/11.jpg");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Picture of John");
            attachment.setName("John");

            // Create the attachment
            EmailAttachment attachment_1 = new EmailAttachment();
            attachment_1.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
            attachment_1.setDisposition(EmailAttachment.ATTACHMENT);
            attachment_1.setDescription("Apache logo");
            attachment_1.setName("我的份");

            email.setFrom("xybb_admin@163.com"); //发送方,这里可以写多个
            email.addTo("liweityut@163.com"); // 接收方
            //email.addCc("402******@qq.com"); // 抄送方
            //email.addBcc("yuaio@163.com"); // 秘密抄送方
            email.setCharset("GB2312");
            email.setSubject("标题哦"); // 标题
            email.setMsg("测试测试内容，请查阅！！！");// 内容

            email.attach(attachment);
            email.attach(attachment_1);
            email.send();
            System.out.println("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    /**
     * HtmlEmail
     * 带附件邮件发送
     */
    public static void sendHtmlEmail() {
        HtmlEmail email = new HtmlEmail();
        //email.setTLS(true); //是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验
        email.setDebug(true);
        //email.setSSL(true);
        email.setHostName("smtp.163.com");
        email.setAuthenticator(new DefaultAuthenticator("xybb_admin@163.com", "xybb_admin_liwei"));
        try {
            email.setFrom("xybb_admin@163.com"); //发送方,这里可以写多个
            email.addTo("liweityut@163.com"); // 接收方
            //email.addCc("402******@qq.com"); // 抄送方
            //email.addBcc("yuaio@163.com"); // 秘密抄送方
            email.setCharset("GB2312");
            email.setSubject("标题哦"); // 标题
            email.setHtmlMsg("<a href='http://www.baidu.com'>百度一下</b>");

            email.send();
            System.out.println("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendSimpleEmail();
        //sendMultiPartEmail();
        //sendHtmlEmail();
    }
}
