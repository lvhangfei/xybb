package com.xybb.system.parameter;

/**
 * Created by lw on 14-6-18.
 * 系统默认环境信息
 */
public class SystemParameter {

    //是否在进行系统维护中
    public static boolean IS_SYSTEM_MAINTENANCE = false;

    //进行系统维护-提示信息
    public static String SYSTEM_MAINTENANCE_MESSAGE = "";

    //Java 运行时环境版本
    public static final String JAVA_VERSION = System.getProperty("java.version");

    //Java 安装目录
    public static final String JAVA_HOME = System.getProperty("java.home");

    //操作系统的名称
    public static final String OS_NAME = System.getProperty("os.name");

    //操作系统的架构
    public static final String OS_ARCH = System.getProperty("os.arch");

    //操作系统的版本
    public static final String OS_VERSION = System.getProperty("os.version");

    //文件分隔符（在 UNIX 系统中是“/”）
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

    //路径分隔符（在 UNIX 系统中是“:”）
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");

    //行分隔符（在 UNIX 系统中是“/n”）
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    //用户的账户名称
    public static final String USER_NAME = System.getProperty("user.name");

    //行分隔符（在 UNIX 系统中是“/n”）
    public static final String USER_HOME = System.getProperty("user.home");

    //用户的当前工作目录
    public static final String USER_DIR = System.getProperty("user.dir");


}
