package com.xybb.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lw on 14-6-21.
 * 用户登录历史信息
 */
public class User_LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @DBRef
    private UserInfo userInfo;

    private long time;//登录时间
    private String ip;//登录IP
    private String os;//用户系统信息
    private String address;//登录地址

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
