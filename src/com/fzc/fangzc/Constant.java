package com.fzc.fangzc;

/**
 * Constant
 * <p>
 * Created by Administrator on 2017/11/1 0001.
 */
public class Constant {
    /**
     * 主机地址
     */
    public static final String DB_HOST = "192.168.1.100:3306";
    /**
     * 访问编码
     */
    public static final String DB_CHARACTER = "/test?useUnicode=true&amp;characterEncoding=utf-8";

    /**
     * 数据库地址“jdbc:mysql://服务器域名:端口号/数据库名称”
     */
    public static final String DB_URL = "jdbc:mysql://" + DB_HOST + DB_CHARACTER;
    /**
     * 用户名
     */
    public static final String DB_USER = "root";
    /**
     * 用户密码
     */
    public static final String DB_PASSWORD = "roems";
    /**
     * 驱动
     */
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * COOKIE
     */
    public static final String COOKIE = "Set-Cookie";
}