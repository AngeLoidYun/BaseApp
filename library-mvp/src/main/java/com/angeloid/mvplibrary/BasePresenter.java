package com.angeloid.mvplibrary;

import android.util.Log;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public class BasePresenter<T extends BaseView> {

    private static final String TAG = "BasePresenter";
    public T mView;
    protected void attachView(T mView){
        Log.i(TAG,"attachView");
        this.mView = mView;
    }

    public void detachView(){
        Log.i(TAG,"detachView");
        this.mView = null;
        unDisposable();
    }

    public void addDisposable(){

    }

    public void unDisposable(){

    }

}
