package com.angeloid.mvplibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public abstract class MvpFragment<P extends BasePresenter> extends SupportFragment implements BaseView{
    protected P presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(checkPresenter()){
            presenter = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if(hidden){
            if(checkPresenter()){
                presenter.unDisposable();
            }
        }
        super.onHiddenChanged(hidden);
    }

    /**
     * 初始化Presenter
     * @return presenter
     */
    protected abstract P initPresenter();

    protected boolean checkPresenter(){
        return presenter != null;
    }
    @Override
    public abstract void showLoading();

    @Override
    public abstract void hideLoading();
}
