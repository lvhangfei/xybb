package com.xybb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by lw on 14-6-19.
 * 帖子内容
 */
public class Forum {

    @Id
    private String id;
    private String title;//标题
    private String content;//内容
    @DBRef
    private Forum_Theme forum_theme;//所属主题
    @DBRef
    private Forum_Classify forum_classify;//所属分类
    @DBRef
    private User creator;//创建者
    private Date createTime;//创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Forum_Theme getForum_theme() {
        return forum_theme;
    }

    public void setForum_theme(Forum_Theme forum_theme) {
        this.forum_theme = forum_theme;
    }

    public Forum_Classify getForum_classify() {
        return forum_classify;
    }

    public void setForum_classify(Forum_Classify forum_classify) {
        this.forum_classify = forum_classify;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
