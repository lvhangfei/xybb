package com.xybb.model;

/**
 * Created by lw on 14-7-9.
 * 百度IP地址解析bean
 * http://api.map.baidu.com/location/ip
 */

/*
    {
    address: "CN|北京|北京|None|CHINANET|1|None",   #地址
    content:       #详细内容
    {
    address: "北京市",   #简要地址
    address_detail:      #详细地址信息
    {
    city: "北京市",        #城市
    city_code: 131,       #百度城市代码
    district: "",           #区县
    province: "北京市",   #省份
    street: "",            #街道
    street_number: ""    #门址
    },
    point:               #百度经纬度坐标值
    {
    x: "116.39564504",
    y: "39.92998578"
    }
    },
    status: 0     #返回状态码
    }
     */

public class Ip_BaiDu_Api {
    private String address;
    private Content content;
    private int status;
    private String message;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class Content {
    private Address_detail address_detail;
    private String address;
    private Point point;

    public Address_detail getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(Address_detail address_detail) {
        this.address_detail = address_detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

class Address_detail {
    private String province;
    private String city;
    private String district;
    private String street;
    private String street_number;
    private String city_code;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }
}


class Point {
    private String x;
    private String y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}