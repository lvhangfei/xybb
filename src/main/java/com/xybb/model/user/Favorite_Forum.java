package com.xybb.model.user;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by lw on 14-6-19.
 * 用户收藏的帖子
 */
public class Favorite_Forum {

    @Id
    private String id;
    private String user_Id;//用户Id
    private String focus_Forum__Id;//收藏的帖子ID

    private Date createTime;//创建时间

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

    public String getFocus_Forum__Id() {
        return focus_Forum__Id;
    }

    public void setFocus_Forum__Id(String focus_Forum__Id) {
        this.focus_Forum__Id = focus_Forum__Id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
