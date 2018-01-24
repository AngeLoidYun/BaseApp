package com.angeloid.mvplibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */
public abstract class MvpFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter != null){
            presenter.detachView();
            presenter = null;
        }
    }

    protected abstract P initPresenter();
}
