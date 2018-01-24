package com.angeloid.netlibrary;

import android.app.Application;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public class HttpManager {
    private static Application App;
    public static void init(Application app){
        App =app;
    }

    public static Application getApp(){
        if(App!= null){
            return App;
        }
        throw new NullPointerException("HttpManager should init first!");
    }
}
