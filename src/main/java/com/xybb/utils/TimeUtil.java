package com.xybb.utils;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by lw on 14-6-15.
 * 时间日期操作工具类
 */
public final class TimeUtil {

    //定义日期-时间-周 的格式化字符串,lssues——月份为MM大写，小写默认为分钟数
    private static final String DATE = "yyyy-MM-dd";
    private static final String TIME = "HH:mm:ss";
    private static final String WEEK = "E";

    /**
     * 自定义DateTime
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @param milliseconds
     * @return DateTime
     */
    public static DateTime getDareTime(int year, int month, int day, int hour, int minute, int second, int milliseconds) {
        return new DateTime(year, month, day, hour, minute, second, milliseconds);
    }

    /**
     * 获取当前星期，week
     *
     * @return String
     */
    public static String getNowWeek() {
        return new DateTime().toString(WEEK);
    }

    /**
     * 获取当前日期，Date格式
     *
     * @return String
     */
    public static String getNowDate() {
        return new DateTime().toString(DATE);
    }

    /**
     * 获取当前时间，Time格式
     *
     * @return String
     */
    public static String getNowTime() {
        return new DateTime().toString(DATE + " " + TIME);
    }

    /**
     * 计算当前时间的时间戳
     *
     * @return 时间戳
     */
    public static long getNowTimeToLong() {
        return new DateTime().getMillis();
    }


    /**
     * 获取long时间戳对应的Data格式返回
     *
     * @return String
     */
    public static String getLong2Date(long l) {
        return new DateTime(l).toString(DATE);
    }

    /**
     * 获取long时间戳对应的Time格式返回
     *
     * @return String
     */
    public static String getLong2Time(long l) {
        return new DateTime(l).toString(DATE + " " + TIME);
    }


    /**
     * 根据多个参数自己组建日期格式，默认不含空格
     *
     * @param parameter
     * @return String
     */
    public static String getTimeForParameter(String parameter) {
        return new DateTime().toString(parameter);
    }


    /**
     * 计算当前时间后半小时的时间戳
     *
     * @return 时间戳
     */
    public static long getNowTimeToHalfHourToLong() {
        return new DateTime().plusHours(30).getMillis();
    }


    /**
     * 获取时间戳与现在时间戳的比较值
     *
     * @param millis
     * @return
     */
    public static String getMillis2NowTime(final long millis) {

        //两个时间戳除以1000以秒为单位计算
        long now = new DateTime().getMillis() / 1000;
        long value = now - (millis / 1000);
        if (value == 0) {
            return "刚刚";
        } else if (0 < value && value < 60) {
            return value + "秒前";
        }
        //以分钟计算
        value = value / 60;
        if (0 < value && value < 60) {
            return value + "分钟前";
        }

        //以小时计算
        value = value / 60;
        if (0 < value && value < 60) {
            return value + "小时前";
        }

        //以天计算 1-31
        value = value / 24;
        if (0 < value && value < 31) {
            return value + "天前";
        }
        //其它时间返回Time日期格式
        return getLong2Time(millis);
    }

    /**
     * other demo
     *
     * @return String
     */
    public static String computationDate() {
        DateTime dateTime = new DateTime();
        //日期 +-
        dateTime = dateTime.plusDays(1);
        //日期比较
        dateTime.isAfterNow();
        dateTime.isBefore(dateTime.getMillis());
        //获取当前分钟数of这个小时
        dateTime.getMinuteOfHour();
        //与 jdk日期 互通
        Date jdkDate = new Date();
        dateTime = new DateTime(jdkDate);
        return "";
    }

    public static void main(String[] args) {
        //System.out.println(getNowTimeToLong());
        long l = 1404025572827L;
        System.out.println(getMillis2NowTime(getNowTimeToLong()));
    }

}
