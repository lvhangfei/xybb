package com.xybb.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by lw on 14-6-28.
 * email 工具类
 */
public class EmailUtil {

    /**
     * email邮件配置文件
     */
    private static Properties email_Properties = new Properties();
    private static String encoding_Mail_Properties;

    /**
     * 读取properties配置文件信息
     */
    static {
        try {
            email_Properties.load(EmailUtil.class.getClassLoader().getResourceAsStream("email.properties"));
            encoding_Mail_Properties = email_Properties.getProperty("read_charset");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key得到value的值
     */
    public static String getValue(String key) {
        String value = email_Properties.getProperty(key);
        try {
            value = new String(value.getBytes("ISO8859-1"), encoding_Mail_Properties);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
