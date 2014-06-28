package com.xybb.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lw on 14-6-21.
 * 用户简单信息
 */
@Repository
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String emailName;//用户邮箱
    private String alias_Name;//用户别名

    private String password;

    @DBRef
    private UserDetailedInfo userDetailedInfo;//用户的详细信息

    private boolean isAdmin = false;//是否是管理员

    private int state = 0;//用户状态0正常，1被账户锁定，2 被ip锁定
    private long lock_Time;//锁定截止日期
    private String lock_Explain;//锁定原因说明
    private List<String> lock_IP;//此用户被锁定的ip

    private String cookie;//记录的自动登录cookie


    /**
     * 由注册用户临时记录生成持久化简单用户信息对象
     *
     * @param userRegister
     * @return
     */
    public static UserInfo getUserInfoByUserRegister(UserRegister userRegister) {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmailName(userRegister.getEmailName());
        userInfo.setPassword(userRegister.getPassword());
        return userInfo;
    }

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

    public String getAlias_Name() {
        return alias_Name;
    }

    public void setAlias_Name(String alias_Name) {
        this.alias_Name = alias_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetailedInfo getUserDetailedInfo() {
        return userDetailedInfo;
    }

    public void setUserDetailedInfo(UserDetailedInfo userDetailedInfo) {
        this.userDetailedInfo = userDetailedInfo;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getLock_Time() {
        return lock_Time;
    }

    public void setLock_Time(long lock_Time) {
        this.lock_Time = lock_Time;
    }

    public String getLock_Explain() {
        return lock_Explain;
    }

    public void setLock_Explain(String lock_Explain) {
        this.lock_Explain = lock_Explain;
    }

    public List<String> getLock_IP() {
        return lock_IP;
    }

    public void setLock_IP(List<String> lock_IP) {
        this.lock_IP = lock_IP;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
