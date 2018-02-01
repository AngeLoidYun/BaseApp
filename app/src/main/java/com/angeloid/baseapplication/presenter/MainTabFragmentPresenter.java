package com.angeloid.baseapplication.presenter;

import com.angeloid.baseapplication.bean.TabType;
import com.angeloid.baseapplication.bean.response.SearchResponse;
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

public class MainTabFragmentPresenter extends BasePresenter<MainTabFragmentView> implements TabFragmentFetchData {
    /**
     * 当前页码
     */
    protected int mCurrentPageNum = 0;
    /**
     * 当前Tab型号
     *
     * @see TabType 在这里可以看到类型对应push到服务器的编号
     */
    private TabType tabType;

    public void setTabType(TabType tabType) {
        this.tabType = tabType;
    }


    public MainTabFragmentPresenter(MainTabFragmentView mainTabFragmentView) {
        super(mainTabFragmentView);
    }


    @Override
    public void fetchOriginData() {
        Logger.i("fetchOriginData");
        AbsRxCallback<HttpResponse<SearchResponse>> appCallback = new AbsRxCallback<HttpResponse<SearchResponse>>() {
            @Override
            public void onSuccess(HttpResponse<SearchResponse> model) {
                Logger.i("success!!!");
                /*
                加载成功咯
                 */
                mView.setOriginData(model.getData().getData_list());
            }

            @Override
            public void onFailure(String errorCode, String errorMsg) {
                /*
                芽儿，这咋失败了呢
                 */
                mView.setOriginDataFailed(errorCode, errorMsg);
            }

            @Override
            public void onFinish() {

            }
        };
        SearchRequest searchRequest = new SearchRequest(1,0);
        searchRequest.setInstall_position(tabType.getTypeNumToServer());
        HttpUtils.getSearchResponse(searchRequest, appCallback);
        addDisposable(appCallback);
    }

    @Override
    public void fetchMoreData() {

    }
}
