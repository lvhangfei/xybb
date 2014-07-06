package com.xybb.utils.ip;

import com.xybb.model.AjaxResult;

/**
 * Created by lw on 14-7-5.
 * 参数	含义	          格式	    说明
 * ip	    ip地址	       string	可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
 * ak	    用户密钥	       string	必选，在lbs云官网注册的access key，作为访问的依据
 * sn	    用户的权限签名	   string	可选，若用户所用ak的校验方式为sn校验时该参数必须。（sn生成算法）
 * coor	    输出的坐标格式	   string	可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
 * <p/>
 * //http://api.map.baidu.com/location/ip?ak=EFfee49fcb850d465bd2d2d26b30b050
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