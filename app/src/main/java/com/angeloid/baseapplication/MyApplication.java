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
        BaseManager.init(this,"---LogTag---",true);
        HttpManager.init(this);
    }
}
