package com.xybb.cache;

import com.xybb.system.parameter.CacheParameter;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

/**
 * Created by lw on 14-6-17.
 */
@Component
public class MemcachedClient_Demo {

    @Resource(name = "renameCacheClient")
    private MemcachedClient renameMemcachedClient;

    public String set2Get(String[] strings) throws InterruptedException, MemcachedException, TimeoutException {
        renameMemcachedClient.set(strings[0], CacheParameter.CACHE_EXP_DEFAULT, strings[1]);
        renameMemcachedClient.getTimeoutExceptionThreshold();
        return renameMemcachedClient.get(strings[0]);
    }
}
