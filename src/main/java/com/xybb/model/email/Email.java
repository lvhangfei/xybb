package com.xybb.model.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lw on 14-6-25.
 * 邮件信息bean
 */
public abstract class Email {

    @Value("${hostName}")
    private String hostName;//服务器名称
    private String[] toEmailNames;//接收方email
    private String[] toNames;//接收方email对应别名
    private String[] ccEmailNames;//抄送方email
    private String[] bccEmailNames;//秘密抄送方email
    private String charset = "GB2312";//编码

    private String title;//邮件标题
    private String msg;//邮件内容

    private boolean isDebug = false;//是否启动debug模式
    private boolean isTLS = false;//启用TLS验证
    private boolean isSSL = false;//启用SSL验证

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String[] getToNames() {
        return toNames;
    }

    public void setToNames(String[] toNames) {
        this.toNames = toNames;
    }

    public String[] getToEmailNames() {
        return toEmailNames;
    }

    public void setToEmailNames(String[] toEmailNames) {
        this.toEmailNames = toEmailNames;
    }

    public String[] getCcEmailNames() {
        return ccEmailNames;
    }

    public void setCcEmailNames(String[] ccEmailNames) {
        this.ccEmailNames = ccEmailNames;
    }

    public String[] getBccEmailNames() {
        return bccEmailNames;
    }

    public void setBccEmailNames(String[] bccEmailNames) {
        this.bccEmailNames = bccEmailNames;
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
