package com.xybb.model.area;

import org.springframework.data.annotation.Id;

/**
 * Created by lw on 14-6-21.
 * 市级地区信息
 */
public class City {
    @Id
    private String id;
    private String name;

    private Province province;//所属省

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
