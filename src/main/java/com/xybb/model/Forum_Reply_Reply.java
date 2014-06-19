package com.xybb.model;

/**
 * Created by lw on 14-6-19.
 * 帖子回复-对帖子回复的楼层进行回复
 */
public class Forum_Reply_Reply extends Abstract_Forum_Reply {

    private String forum_Reply;//回复帖子回复的 ID

    public String getForum_Reply() {
        return forum_Reply;
    }

    public void setForum_Reply(String forum_Reply) {
        this.forum_Reply = forum_Reply;
    }
}
