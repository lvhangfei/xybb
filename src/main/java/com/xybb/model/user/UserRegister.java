package com.xybb.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lw on 14-6-27.
 * 用户注册，修改密码，邮件激活链接临时记录表
 */
@Repository
public class UserRegister {

    @Id
    private String id;
    @Indexed
    private String emailName;//用户邮箱
    private String password;
    private int tag = 0;//0-注册，1-修改密码
    private String uuid;//临时UUID记录值
    private long registerTime;//邮箱激活截止时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "id='" + id + '\'' +
                ", emailName='" + emailName + '\'' +
                ", password='" + password + '\'' +
                ", uuid='" + uuid + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
