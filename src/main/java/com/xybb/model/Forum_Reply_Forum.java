package com.xybb.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by lw on 14-6-19.
 * 帖子回复-帖子直接回复
 */
public class Forum_Reply_Forum extends Abstract_Forum_Reply {

    private String forum_Id;//回复帖子的 ID
    private int index = 1;//被赞次数

    public String getForum_Id() {
        return forum_Id;
    }

    public void setForum_Id(String forum_Id) {
        this.forum_Id = forum_Id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
