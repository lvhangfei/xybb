package com.xybb.model.forum;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by lw on 14-6-21.
 * 帖子--发布细节--关键字--建立搜索引擎
 * ---------------
 * 使用户可以快速查询
 */
public class Forum_Keyword {

    @Id
    private String id;

    private String forum_Id;//帖子Id
    private String forum_Title;//帖子标题
    private String user_Id;//帖子-发布人
    private String school_Id;//帖子-发布的学校
    private String area_Id;//帖子-发布的地区
    private String city_Id;//帖子-发布的市

    private List<String> keywords;//帖子自定义-关键字

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

    public String getForum_Title() {
        return forum_Title;
    }

    public void setForum_Title(String forum_Title) {
        this.forum_Title = forum_Title;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getSchool_Id() {
        return school_Id;
    }

    public void setSchool_Id(String school_Id) {
        this.school_Id = school_Id;
    }

    public String getArea_Id() {
        return area_Id;
    }

    public void setArea_Id(String area_Id) {
        this.area_Id = area_Id;
    }

    public String getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(String city_Id) {
        this.city_Id = city_Id;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
