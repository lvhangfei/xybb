package com.xybb.model;

import java.util.List;

/**
 * Created by lw on 14-6-18.
 * 管理员
 */
public class User_Admin extends User {

    private List<Forum_Classify> forum_classifies;//管理的主题分类

    public List<Forum_Classify> getForum_classifies() {
        return forum_classifies;
    }

    public void setForum_classifies(List<Forum_Classify> forum_classifies) {
        this.forum_classifies = forum_classifies;
    }
}
