package com.xybb.model.user;

import com.xybb.model.forum.Forum_Classify;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by lw on 14-6-22.
 * 用户操作动态记录
 */
public class User_ActionInfo {

    @Id
    private String id;

    @DBRef
    private UserInfo userInfo;

    private int action_Num;//用户动作： 1发表帖子 2发表回复
    private boolean isRead;//他人是否可以读--针对用户只对楼主回复的内容下别人不应该看到此动态

    private String action_Id;//对应的帖子ID

    private String action_Title;//帖子标题
    private String action_Content;//帖子内容or回复内容--只记录部分内容

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getAction_Num() {
        return action_Num;
    }

    public void setAction_Num(int action_Num) {
        this.action_Num = action_Num;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
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
