package com.angeloid.mvplibrary;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public class BasePresenter<T extends BaseView> {
    public  BasePresenter(T t){
        attachView(t);
    }
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


    //-----------------分割线---------------------
    //以下下为配合RxJava2+retrofit2使用的

    //将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;

    /**
     * 将Disposable添加
     *
     * @param subscription
     */
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        Log.i(TAG, "addDisposable");
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            Log.i(TAG, "unDisposable");
            mCompositeDisposable.dispose();
        }
    }


}
