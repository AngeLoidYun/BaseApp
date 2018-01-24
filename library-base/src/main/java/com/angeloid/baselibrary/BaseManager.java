package com.angeloid.baselibrary;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.maning.librarycrashmonitor.MCrashMonitor;
import com.maning.librarycrashmonitor.listener.MCrashCallBack;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.File;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public class BaseManager {

    private static Application sApplication;

    public static void init(Application application, String LogTag, boolean isDebug) {
        sApplication = application;
        /*日志初始化*/
        initLog(LogTag, isDebug);
        /*工具类初始化*/
        initCommonUtils();
        /*数据存储初始化*/
        initCache();
        /*崩溃日志监听*/
        initCrashLog(isDebug);
    }

    private static void initCrashLog(boolean isDebug) {
        /**
         * 初始化日志系统
         * context :    上下文
         * isDebug :    是不是Debug模式,true:崩溃后显示自定义崩溃页面 ;false:关闭应用,不跳转奔溃页面(默认)
         * CrashCallBack : 回调执行
         */
        MCrashMonitor.init(sApplication, isDebug, new MCrashCallBack() {
            @Override
            public void onCrash(File file) {
                //可以在这里保存标识，下次再次进入把日志发送给服务器
                Logger.i("----------CrashFile---------:" + file.getAbsolutePath());
            }
        });
    }

    private static void initCache() {
        Hawk.init(sApplication);
    }

    private static void initCommonUtils() {
        Utils.init(sApplication);
    }

    private static void initLog(String LogTag, final boolean isDebug) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(1)
                .methodOffset(0)
                .tag(LogTag)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isDebug;
            }
        });
        Logger.i("----------日志初始化成功---------");
    }
}
