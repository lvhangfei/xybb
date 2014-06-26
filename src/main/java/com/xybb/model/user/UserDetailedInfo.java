package com.xybb.model.user;

import com.xybb.model.forum.Forum_Classify;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lw on 14-6-15.
 * 用户详细信息
 */
public class UserDetailedInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private int sex = 0;//性别，0女，1男
    private int age;//年龄由生日自动计算录入
    private Date birthday;//生日
    private String area_Id;//所属地区-递归查询到省

    @Indexed
    private String school;//学校
    private String discipline;//专业

    private int graduate_Year;//毕业时间-针对非已毕业用户

    private String portrait;//个人头像
    private int love_State = 0;//恋爱状态: 0单身，1热恋，2已婚，3离异
    private String explain;//个人说明

    private List<UserInfo> userInfos;//关注的用户
    private List<Forum_Classify> forum_Classifies;//关注的功能分类
    private Map<String, List<String>> keyword;//用户在每个分类下自定义的关键字-发帖时候添加

    private int state;//用户状态0正常，1被账户锁定，2 被ip锁定
    private Date lock_Time;//锁定截止日期
    private String lock_Explain;//锁定原因说明
    private List<String> lock_IP;//此用户被锁定的ip


    private List<String> cookies;//记录的自动登录cookie
    private Date createTime;//用户创建时间

    private boolean isAdmin = false;//是否是管理员

    public UserDetailedInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getArea_Id() {
        return area_Id;
    }

    public void setArea_Id(String area_Id) {
        this.area_Id = area_Id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getGraduate_Year() {
        return graduate_Year;
    }

    public void setGraduate_Year(int graduate_Year) {
        this.graduate_Year = graduate_Year;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getLove_State() {
        return love_State;
    }

    public void setLove_State(int love_State) {
        this.love_State = love_State;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    public List<Forum_Classify> getForum_Classifies() {
        return forum_Classifies;
    }

    public void setForum_Classifies(List<Forum_Classify> forum_Classifies) {
        this.forum_Classifies = forum_Classifies;
    }

    public Map<String, List<String>> getKeyword() {
        return keyword;
    }

    public void setKeyword(Map<String, List<String>> keyword) {
        this.keyword = keyword;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getLock_Time() {
        return lock_Time;
    }

    public void setLock_Time(Date lock_Time) {
        this.lock_Time = lock_Time;
    }

    public String getLock_Explain() {
        return lock_Explain;
    }

    public void setLock_Explain(String lock_Explain) {
        this.lock_Explain = lock_Explain;
    }

    public List<String> getLock_IP() {
        return lock_IP;
    }

    public void setLock_IP(List<String> lock_IP) {
        this.lock_IP = lock_IP;
    }

    public List<String> getCookies() {
        return cookies;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
