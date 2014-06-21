package com.xybb.model.forum;

/**
 * Created by lw on 14-6-19.
 * 帖子主题
 */
public class Forum_Theme {

    private String id;
    private String name;
    private int sort;//排序

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
}
