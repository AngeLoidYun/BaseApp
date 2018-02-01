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
    public static void init(Application app,String baseUrl){
        App =app;
        API_SERVER_BASE_URL = baseUrl;
    }

    public static Application getApp(){
        if(App!= null){
            return App;
        }
        throw new NullPointerException("HttpManager should init first!");
    }
}
