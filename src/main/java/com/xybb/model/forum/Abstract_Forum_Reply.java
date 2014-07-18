package com.xybb.model.forum;

import com.xybb.model.user.UserInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by lw on 14-6-19.
 * 帖子回复
 */
public abstract class Abstract_Forum_Reply {

    @Id
    private String id;
    private String forum_Id;//回复的帖子的ID

    private String content;//回复内容

    @DBRef
    private UserInfo creator;//创建者
    private long createTime;//创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForum_Id() {
        return forum_Id;
    }

    public void setForum_Id(String forum_Id) {
        this.forum_Id = forum_Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfo getCreator() {
        return creator;
    }

    public void setCreator(UserInfo creator) {
        this.creator = creator;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
