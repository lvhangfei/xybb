package com.xybb.model.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-25.
 * 邮件信息bean
 */
public abstract class Email {

    @Value("${hostName}")
    private String hostName;//服务器名称
    private String toName;//接收方名称
    private String ccName;//抄送方名称
    private String bccName;//秘密抄送方名称
    private String charset = "GB2312";//编码

    private String title;//邮件标题
    private String msg;//邮件内容

    private boolean isDebug = false;//是否启动debug模式
    private boolean isTLS = false;//启用TLS验证
    private boolean isSSL = false;//启用SSL验证

    public String getHostName() {
        return hostName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getBccName() {
        return bccName;
    }

    public void setBccName(String bccName) {
        this.bccName = bccName;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public boolean isTLS() {
        return isTLS;
    }

    public void setTLS(boolean isTLS) {
        this.isTLS = isTLS;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setSSL(boolean isSSL) {
        this.isSSL = isSSL;
    }
}
