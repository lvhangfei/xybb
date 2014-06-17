package com.xybb.system.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-17.
 * 缓存参数
 */
@Component
public class CacheParameter {

    @Value("#{memcachedProperties['memcached.timeout']}")
    public static int CACHE_TIMEOUT = 0;//缓存超时

    // 一个过期时间,以秒为单位。可达30天。经过30*天,被视为一个unix时间戳的确切日期
    @Value("#{memcachedProperties['memcached.exp']}")
    public static int CACHE_EXP;

    @Value("#{memcachedProperties['memcached.autocomplete.update']}")
    public static int CACHE_AUTOCOMPLETE_UPDATE;//缓存自动更新时间间隔

    private CacheParameter() {
    }

}
