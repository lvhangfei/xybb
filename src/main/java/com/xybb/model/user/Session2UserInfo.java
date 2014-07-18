package com.xybb.model.user;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by lw on 14-6-15.
 * 用户session信息
 */
public class Session2UserInfo {

    private String alias_Name;//用户别名,为空默认为邮箱名称
    private boolean isAdmin = false;//是否管理员
    private String userInfo_Id;//关联ID

    /**
     * 设置用户session信息
     *
     * @param userInfo
     * @return
     */
    public static Session2UserInfo getSession2UserInfo(UserInfo userInfo) {
        Session2UserInfo session2UserInfo = new Session2UserInfo();
        String alias_Name = userInfo.getAlias_Name();
        //如果有别名显示别名，否则默认显示邮箱
        if (StringUtils.isNotBlank(alias_Name)) {
            session2UserInfo.alias_Name = alias_Name;
        } else {
            session2UserInfo.alias_Name = userInfo.getEmailName();
        }
        session2UserInfo.isAdmin = userInfo.isAdmin();
        session2UserInfo.userInfo_Id = userInfo.getId();
        return session2UserInfo;
    }

    public String getAlias_Name() {
        return alias_Name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getUserInfo_Id() {
        return userInfo_Id;
    }
}
