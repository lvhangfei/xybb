package com.xybb.model.area;

import org.springframework.data.annotation.Id;

/**
 * Created by lw on 14-6-21.
 * 学校所属地区信息
 */
public class School {
    @Id
    private String id;
    private String name;

    private Area area;//所属地级市区

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
