package com.xybb.utils;

import com.xybb.model.email.Email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by lw on 14-6-28.
 * email 工具类
 */
public class EmailUtil {


    private static Properties email_Pro = new Properties();
    private static String encoding;

    /**
     * 读取properties配置文件信息
     */
    static {
        try {
            email_Pro.load(EmailUtil.class.getClassLoader().getResourceAsStream("email.properties"));
            encoding = email_Pro.getProperty("read_charset");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key得到value的值
     */
    public static String getValue(String key) {
        String value = email_Pro.getProperty(key);
        try {
            value = new String(value.getBytes("ISO8859-1"), encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
