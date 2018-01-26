package com.angeloid.baseapplication.presenter;

import com.angeloid.baseapplication.bean.CategoryBean;
import com.angeloid.baseapplication.bean.base.HttpResponse;
import com.angeloid.baseapplication.net.HttpUtils;
import com.angeloid.baseapplication.view.method.MainView;
import com.angeloid.mvplibrary.BasePresenter;
import com.angeloid.mvplibrary.BaseView;
import com.angeloid.netlibrary.callback.AbsRxCallback;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * @author yunjw
 *         Created at 2018/1/25.
 *         Time is 10:31 now.
 *         (#^.^#)
 */

public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView mainView) {
        super(mainView);
    }

    public void getAppData(){
        Logger.i("getAppData");
        AbsRxCallback<HttpResponse<List<CategoryBean>>> appCallback = new AbsRxCallback<HttpResponse<List<CategoryBean>>>() {
            @Override
            public void onSuccess(HttpResponse<List<CategoryBean>> model) {
                mView.showAppDetail(model.getData().get(0));
            }

            @Override
            public void onFailure(String errorCode, String errorMsg) {
                mView.showToast(errorCode+errorMsg);
            }

            @Override
            public void onFinish() {
//                mView.showToast("finish!");
            }
        };
        HttpUtils.getAppData(appCallback);
        addDisposable(appCallback);
    }

}
