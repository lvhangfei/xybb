package com.xybb.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by lw on 14-6-29.
 * 系统日志信息工厂
 */
public final class LogFactoryUtil {

    public static final Log QUARTZ_LOG = LogFactory.getLog("quartzLog");
    public static final Log RUNTIME_LOG = LogFactory.getLog("runtimeLog");
    public static final Log SYSTEMMONITOR_LOG = LogFactory.getLog("systemmonitorLog");
    public static final Log MECACHED_LOG = LogFactory.getLog("mecachedLog");
    public static final Log ES_LOG = LogFactory.getLog("esLog");
    public static final Log EMAIL_LOG = LogFactory.getLog("emailLog");

}
