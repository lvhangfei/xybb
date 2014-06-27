package com.xybb.utils;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by lw on 14-6-15.
 * 时间日期操作工具类
 */
public class TimeUtil {

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
     * 获取当前日期，Date
     *
     * @return String
     */
    public static String getNowDate() {
        return new DateTime().toString(DATE);
    }

    /**
     * 获取当前时间，Time
     *
     * @return String
     */
    public static String getNowTime() {
        return new DateTime().toString(DATE + " " + TIME);
    }

    /**
     * 获取当前时间，Time
     *
     * @param dateTime
     * @return String
     */
    public static String getDateTime(DateTime dateTime) {
        return dateTime.toString(DATE + " " + TIME);
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
     * 计算五年后的第二个月的最后一天-demo
     * monthOfYear()     // get monthOfYear property
     *
     * @param dateTime
     * @return String
     */
    public static String computationDateDemo(DateTime dateTime) {
        dateTime = dateTime.plusYears(5).monthOfYear().setCopy(2).dayOfMonth().withMaximumValue();
        return getDateTime(dateTime);
    }

    /**
     * 计算当前时间后半小时的时间戳
     *
     * @return 时间戳
     */
    public static long getNowTimeToHalfHour() {
        return new DateTime().plusHours(30).getMillis();
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

        return getDateTime(dateTime);
    }

}
