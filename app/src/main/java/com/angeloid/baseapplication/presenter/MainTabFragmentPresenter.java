package com.angeloid.baseapplication.presenter;

import com.angeloid.baseapplication.bean.SearchResponse;
import com.angeloid.baseapplication.bean.base.HttpResponse;
import com.angeloid.baseapplication.bean.request.SearchRequest;
import com.angeloid.baseapplication.net.HttpUtils;
import com.angeloid.baseapplication.view.method.MainTabFragmentView;
import com.angeloid.baseapplication.view.method.TabFragmentFetchData;
import com.angeloid.mvplibrary.BasePresenter;
import com.angeloid.netlibrary.callback.AbsRxCallback;
import com.orhanobut.logger.Logger;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 12:47 now.
 *         (#^.^#)
 */

public class MainTabFragmentPresenter extends BasePresenter<MainTabFragmentView> implements TabFragmentFetchData{
    public MainTabFragmentPresenter(MainTabFragmentView mainTabFragmentView) {
        super(mainTabFragmentView);
    }



    @Override
    public void fetchOriginData(SearchRequest searchOriginRequest) {
        Logger.i("fetchOriginData");
        AbsRxCallback<HttpResponse<SearchResponse>> appCallback = new AbsRxCallback<HttpResponse<SearchResponse>>() {
            @Override
            public void onSuccess(HttpResponse<SearchResponse> model) {
                Logger.i("success!!!");
                /*
                加载成功咯
                 */
                mView.setMainData(model.getData().getData_list());
            }

            @Override
            public void onFailure(String errorCode, String errorMsg) {
                /*
                芽儿，这咋失败了呢
                 */
                mView.setMainDataFailed(errorCode,errorMsg);
            }

            @Override
            public void onFinish() {

            }
        };
        HttpUtils.getSearchResponse(searchOriginRequest,appCallback);
        addDisposable(appCallback);
    }

    @Override
    public void fetchMoreData(SearchRequest searchMoreRequest) {

    }
}
