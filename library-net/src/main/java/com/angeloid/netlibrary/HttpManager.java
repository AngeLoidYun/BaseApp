package com.angeloid.netlibrary;

import android.app.Application;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public class HttpManager {
    private static Application App;
    /**
     * 网络请求基础URL
     */
    public static String API_SERVER_BASE_URL;
    public static String API_SERVER_BASE_URL_OLD;
    public static void init(Application app,String baseUrl,String baseUrlOld){
        App =app;
        API_SERVER_BASE_URL = baseUrl;
        API_SERVER_BASE_URL_OLD = baseUrlOld;
    }

    public static Application getApp(){
        if(App!= null){
            return App;
        }
        throw new NullPointerException("HttpManager should init first!");
    }
}
