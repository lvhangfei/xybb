package com.xybb.model;

/**
 * Created by lw on 14-6-19.
 * 帖子分类
 */
public class Forum_Classify {

    private String id;
    private String name;
    private int sort;//排序
    private int index;//被关注次数

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
