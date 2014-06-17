package com.xybb.system.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-17.
 * 缓存参数
 */
@Component
public class CacheParameter {

    /**
     * 定义了秒--->年的时间常量，秒为单位
     */
    public static final int CACHE_EXP_SECOND = 1;
    public static final int CACHE_EXP_MINUTE = CACHE_EXP_SECOND * 60;
    public static final int CACHE_EXP_HOUR = CACHE_EXP_MINUTE * 60;
    public static final int CACHE_EXP_DAY = CACHE_EXP_HOUR * 24;
    public static final int CACHE_EXP_WEEK = CACHE_EXP_DAY * 7;
    public static final int CACHE_EXP_MONTH = CACHE_EXP_DAY * 30;
    public static final int CACHE_EXP_YEAR = CACHE_EXP_DAY * 365;

    @Value("#{memcachedProperties['memcached.timeout']}")
    public static int CACHE_TIMEOUT = 0;//缓存超时

    // 一个过期时间,以秒为单位。可达30天。经过30*天,被视为一个unix时间戳的确切日期
    @Value("#{memcachedProperties['memcached.exp.default']}")
    public static int CACHE_EXP_DEFAULT;


    @Value("#{memcachedProperties['memcached.autocomplete.update']}")
    public static int CACHE_AUTOCOMPLETE_UPDATE;//缓存自动更新时间间隔

    private CacheParameter() {
    }

}
