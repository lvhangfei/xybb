package com.xybb.model.user;

import org.springframework.data.annotation.Id;

/**
 * Created by lw on 14-6-22.
 * 管理员操作记录
 */
public class Admin_ActionInfo {

    @Id
    private String id;
    private String user_Id;

    private int action_Num;//用户动作： 1删除帖子 2删除回复

    private String action_Id;//对应的帖子ID

    private String action_Title;//帖子标题

    private String action_Content;//帖子内容or回复内容--只记录部分内容


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

    public int getAction_Num() {
        return action_Num;
    }

    public void setAction_Num(int action_Num) {
        this.action_Num = action_Num;
    }


    public String getAction_Id() {
        return action_Id;
    }

    public void setAction_Id(String action_Id) {
        this.action_Id = action_Id;
    }

    public String getAction_Title() {
        return action_Title;
    }

    public void setAction_Title(String action_Title) {
        this.action_Title = action_Title;
    }

    public String getAction_Content() {
        return action_Content;
    }

    public void setAction_Content(String action_Content) {
        this.action_Content = action_Content;
    }
}
