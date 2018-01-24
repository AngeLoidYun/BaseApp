package com.angeloid.netlibrary.callback;

import com.angeloid.netlibrary.constants.HttpErrorConstants;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public abstract class AbsRxCallback<M> extends DisposableObserver<M> {
    public abstract void onSuccess(M model);

    public abstract void onFailure(String errorCode,String errorMsg);

    public abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String errorCode = HttpErrorConstants.ERR_NETEXCEPTION_ERROR_CODE;
        String errorMsg;
        if(e instanceof UnknownHostException || e instanceof ConnectException){
            errorMsg = HttpErrorConstants.ERR_UNKNOWNHOSTEXCEPTION_ERROR;
        }else if (e instanceof SocketTimeoutException) {
            //连接超时
            errorMsg = HttpErrorConstants.ERR_SOCKETTIMEOUTEXCEPTION_ERROR;
        } else {
            //其他网络异常
            errorMsg = HttpErrorConstants.ERR_NETEXCEPTION_ERROR;
        }
        onFailure(errorCode,errorMsg);
        onFinish();
    }
    @Override
    public void onNext(M model) {
        onSuccess(model);
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
