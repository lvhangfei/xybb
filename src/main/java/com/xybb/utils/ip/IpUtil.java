package com.xybb.utils.ip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xybb.model.AjaxResult;
import com.xybb.model.Ip_BaiDu_Api;
import com.xybb.system.parameter.ProjectParameter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by lw on 14-6-15.
 * <p/>
 * ip地址解析
 */
public class IpUtil {


    //IP地址请求链接
    private static final String IP_HOST_ADDRESS = "http://api.map.baidu.com/location/ip?ak=" + ProjectParameter.BAIDU_IP_API_AK + "&ip=";
    private static final String ENCODING = "utf-8";

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

    /**
     * 调用webservice获取ip地址
     * 验证数据格式并处理结果集
     *
     * @param ip
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static AjaxResult getAddressByIp(String ip) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(ip)) {
            return new AjaxResult("IP不合法", false);
        }
        //拼接最终请求链接
        String returnStr = getResultByUrlPath(IP_HOST_ADDRESS + ip);
        if (null == returnStr) {
            return new AjaxResult("IP解析出错", false);
        }
        Ip_BaiDu_Api ip_baiDu_api;
        try {
            ip_baiDu_api = new ObjectMapper().readValue(returnStr, Ip_BaiDu_Api.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new AjaxResult("IP解析封装bean出错", false);
        }

        //获取返回状态码
        int status = ip_baiDu_api.getStatus();
        switch (status) {
            case 0:
                return new AjaxResult(true, ip_baiDu_api);
            case 1:
                return new AjaxResult("服务器内部错误", false, ip_baiDu_api);
            case 2:
                return new AjaxResult("请求参数非法", false, ip_baiDu_api);
            case 3:
                return new AjaxResult("权限校验失败", false, ip_baiDu_api);
            case 4:
                return new AjaxResult("配额校验失败", false, ip_baiDu_api);
            case 5:
                return new AjaxResult("ak不存在或者非法", false, ip_baiDu_api);
            default:
                return AjaxResult.getAjaxResult(AjaxResult.State.ERROR);

        }
    }

    /**
     * 请求webServicr并获取结果集
     *
     * @param url_Path 请求的地址
     * @return 数据处理出错返回null
     */
    private static String getResultByUrlPath(String url_Path) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(url_Path);
            connection = (HttpURLConnection) url.openConnection();// 新建连接实例
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
            DataOutputStream out = new DataOutputStream(connection
                    .getOutputStream());// 打开输出流往对端服务器写数据
            out.flush();// 刷新
            out.close();// 关闭输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), ENCODING));// 往对端写完数据对端服务器返回数据
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();// 关闭连接
            }
        }
    }

    /**
     * 获取本机 IP
     * //TODO 获取的为127.0.0.1
     *
     * @return
     */
    public static String getLocalIp() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return addr.getHostAddress();//获得本机IP
    }

    /**
     * 由request获取ip信息
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static void main(String[] args) {
        String ip = "124.167.47.246";
        try {
            AjaxResult ajaxResult = getAddressByIp(ip);
            System.out.println(ajaxResult.getMsg());
            System.out.println(((Ip_BaiDu_Api) ajaxResult.getObject()).getAddress());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    /*
    * 参数	含义	          格式	    说明
    * ip	    ip地址	       string	可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
    * ak	    用户密钥	       string	必选，在lbs云官网注册的access key，作为访问的依据
    * sn	    用户的权限签名	   string	可选，若用户所用ak的校验方式为sn校验时该参数必须。（sn生成算法）
    * coor	    输出的坐标格式	   string	可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
    */

}
