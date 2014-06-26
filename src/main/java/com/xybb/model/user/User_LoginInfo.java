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
    private String user_Id;

    private Date time;//登录时间
    private String ip;//登录IP
    private String os;//用户系统信息

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
}
