package com.angeloid.baseapplication.net;

import com.angeloid.baseapplication.bean.request.RequestBean;
import com.angeloid.baseapplication.bean.request.SearchRequest;
import com.angeloid.netlibrary.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 9:59 now.
 *         (#^.^#)
 */

public class HttpUtils {

    public static void getAppData(DisposableObserver observer){
        RetrofitClient.createOld()
                .create(RequestApi.class)
                .getApp(new RequestBean(1))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getSearchResponse(SearchRequest searchRequest,DisposableObserver observer){
        RetrofitClient.create()
                .create(RequestApi.class)
                .getSearchResponse(searchRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
