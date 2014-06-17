package com.xybb.model;

import java.util.List;

/**
 * Created by lw on 14-6-15.
 * 普通用户
 */
public class User {

    private String id;
    private String Name;
    private String password;
    private String sex;
    private int age;
    private String birthday;
    private String email;
    private String province;
    private String city;
    private String school;

    private String portrait;//头像

    private List<String> attention_User;//关注的用户
    private List<String> attention_Classify;//关注的功能分类

    private int state;//用户状态0正常，1被账户锁定，2被ip锁定
    private List<String> lockIP;//此用户被锁定的ip

    public User() {
    }
}
