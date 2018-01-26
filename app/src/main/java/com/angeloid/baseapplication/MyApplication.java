package com.angeloid.baseapplication;

import android.app.Application;

import com.angeloid.baselibrary.BaseManager;
import com.angeloid.netlibrary.HttpManager;
import com.squareup.leakcanary.LeakCanary;
/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
        BaseManager.init(this,"---BraveMade---",true);
        HttpManager.init(this);
    }
}
