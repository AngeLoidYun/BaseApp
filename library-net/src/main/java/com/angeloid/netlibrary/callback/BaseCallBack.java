package com.angeloid.netlibrary.callback;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public interface BaseCallBack<T> {
    /**
     * 成功
     */
    void onSuccess(T result);

    /**
     * 失败
     */
    void onFail(String errorCode, String errorMsg);

    /**
     * 完成
     */
    void onFinish();
}
