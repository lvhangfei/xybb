package com.xybb.utils.ip;

import com.xybb.model.AjaxResult;

/**
 * Created by lw on 14-7-5.
 */
public class BaiDu_Ip_Api {
    /*
    0	正常
    1	服务器内部错误
    2	请求参数非法
    3	权限校验失败
    4	配额校验失败
    5	ak不存在或者非法
    101	服务禁用
    102	不通过白名单或者安全码不对
    2xx	无权限
    3xx	配额错误
    */
    public static final String IP_API_STATUS_0 = "0";
    public static final String IP_API_STATUS_1 = "1";
    public static final String IP_API_STATUS_2 = "2";
    public static final String IP_API_STATUS_3 = "3";
    public static final String IP_API_STATUS_4 = "4";
    public static final String IP_API_STATUS_5 = "5";
    public static final String IP_API_STATUS_101 = "101";
    public static final String IP_API_STATUS_102 = "102";
    public static final String IP_API_STATUS_2XX = "2xx";
    public static final String IP_API_STATUS_3XX = "3xx";

    public static AjaxResult getAddressByIpNum(Object o) {


        return null;
    }
}
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
* */