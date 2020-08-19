package com.xzsd.pc.util;

public class RoleUtil {
    //管理员的数据库值
    public static final String ADMIN = "0";
    //店长的数据库值
    public static final String MANAGER = "1";
    //司机的数据库值
    public static final String DRIVER = "2";
    //顾客的数据库值
    public static final String CLIENT = "3";
    //订单状态 已下单
    public static final String PLACED_VALUE = "0";
    //订单状态 待取货
    public static final String WATINGDELIVERY_VALUE = "1";
    //订单状态 已取货
    public static final String TAKEDELIVERY_VALUE = "2";
    //订单状态 已完成未评价
    public static final String SUCCESS_VALUE = "3";
    //订单状态 已评价
    public static final String EVALUETED_VALUE = "4";
    //订单状态 取消
    public static final String CANCEL_VALUE = "5";
}
