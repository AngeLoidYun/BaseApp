package com.angeloid.netlibrary.constants;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 * 错误代码列表
 */

public class HttpErrorConstants {
    //网络错误  90开头
    public static final String ERR_UNKNOWNHOSTEXCEPTION_ERROR = "网络连接失败,请检查网络设置";
    public static final String ERR_SOCKETTIMEOUTEXCEPTION_ERROR = "网络请求超时";
    public static final String ERR_NETEXCEPTION_ERROR = "网络异常";
    public static final String ERR_NETEXCEPTION_ERROR_CODE = "9000";

    //Response返回异常
    public static final String ERR_HTTPRESPONSE_ERROR = "response为空";
    public static final String ERR_HTTPRESPONSE_ERROR_CODE = "9001";
    public static final String ERR_HTTPRESPONSE_HEAD_ERROR = "head为空";
    public static final String ERR_HTTPRESPONSE_HEAD_ERROR_CODE = "9002";
    public static final String ERR_HTTPRESPONSE_JSONPARSE_ERROR = "Json解析异常";
    public static final String ERR_HTTPRESPONSE_JSONPARSE_ERROR_CODE = "9003";


}
