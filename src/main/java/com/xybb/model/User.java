package com.xybb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

/**
 * Created by lw on 14-6-15.
 * 普通用户
 */
public class User {

    @Id
    private String id;
    private String Name;
    private String Alias_Name;//用户别名
    private String password;
    private int sex = 0;//性别，0女，1男
    private int age;//年龄由生日自动计算录入
    private Date birthday;//生日
    private String email;//邮箱
    private String province;//省
    private String city;//市
    private String school;//学校
    private String discipline;//专业

    private String portrait;//头像
    private int love_State = 0;//恋爱状态，0单身，1热恋，2已婚，3离异
    private String explain;//个人说明

    private List<User> users;//关注的用户
    private List<Forum_Classify> forum_classifies;//关注的功能分类

    private int state;//用户状态0正常，1被账户锁定，2被ip锁定
    private String lock_Explain;//锁定说明
    private List<String> lockIP;//此用户被锁定的ip

    private List<String> cookies;//记录的自动登录cookie
    private Date createTime;//用户创建时间

    public User() {
    }


}
