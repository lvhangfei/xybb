package com.xybb.model.area;

import org.springframework.data.annotation.Id;

/**
 * Created by lw on 14-6-21.
 * 省级地区信息
 */
public class Province {
    @Id
    private String id;
    private String name;

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
}
