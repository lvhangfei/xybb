package com.xybb.model;

import com.xybb.model.forum.Forum_Classify;
import com.xybb.model.user.UserInfo;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

/**
 * Created by lw on 14-6-15.
 * 用户权限信息
 */
public class Power {

    private String id;
    private String user_Id;
    private List<Forum_Classify> forum_classifies;//管理的主题分类

    @DBRef
    private UserInfo creator;//创建者

    private Date createTime;//创建时间
    private Date failureTime;//失效时间

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

    public List<Forum_Classify> getForum_classifies() {
        return forum_classifies;
    }

    public void setForum_classifies(List<Forum_Classify> forum_classifies) {
        this.forum_classifies = forum_classifies;
    }

    public UserInfo getCreator() {
        return creator;
    }

    public void setCreator(UserInfo creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }
}
