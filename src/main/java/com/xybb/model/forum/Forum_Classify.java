package com.xybb.model.forum;

import com.xybb.model.user.UserInfo;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by lw on 14-6-19.
 * 帖子分类
 */
public class Forum_Classify {

    private String id;
    private String name;
    private int sort;//排序
    private int focus_Num;//被关注次数

    @DBRef
    private UserInfo creator;//创建者

    private long createTime;//创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getFocus_Num() {
        return focus_Num;
    }

    public void setFocus_Num(int focus_Num) {
        this.focus_Num = focus_Num;
    }

    public UserInfo getCreator() {
        return creator;
    }

    public void setCreator(UserInfo creator) {
        this.creator = creator;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
