package com.angeloid.netlibrary.callback;

import com.angeloid.netlibrary.constants.HttpErrorConstants;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public abstract class AbsRetrofitCallback<M> implements Callback<M>{
    public abstract void onSuccess(M model);

    public abstract void onFailure(String errorCode, String errorMsg);

    public abstract void onFinish();

    @Override
    public void onResponse(Call<M> call, Response<M> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            onFailure(response.code() + "", response.errorBody().toString());
        }
        onFinish();
    }

    @Override
    public void onFailure(Call<M> call, Throwable exception) {
        if (call.isCanceled()) {
            onFinish();
            return;
        }
        exception.printStackTrace();
        String errorCode = HttpErrorConstants.ERR_NETEXCEPTION_ERROR_CODE;
        String errorMsg;
        if (exception instanceof UnknownHostException || exception instanceof ConnectException) {
            //网络未连接
            errorMsg = HttpErrorConstants.ERR_UNKNOWNHOSTEXCEPTION_ERROR;
        } else if (exception instanceof SocketTimeoutException) {
            //连接超时
            errorMsg = HttpErrorConstants.ERR_SOCKETTIMEOUTEXCEPTION_ERROR;
        } else {
            //其他网络异常
            errorMsg = HttpErrorConstants.ERR_NETEXCEPTION_ERROR;
        }
        onFailure(errorCode, errorMsg);
        onFinish();
    }
}
