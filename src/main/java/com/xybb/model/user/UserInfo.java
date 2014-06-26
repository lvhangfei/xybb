package com.xybb.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;

/**
 * Created by lw on 14-6-21.
 * 用户简单信息
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String emailName;//用户邮箱
    private String alias_Name;//用户别名

    private String password;

    @DBRef
    private UserDetailedInfo userDetailedInfo;//用户的详细信息

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
}
