package com.angeloid.baseapplication.base;

import com.angeloid.mvplibrary.BasePresenter;
import com.angeloid.mvplibrary.MvpFragment;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 19:36 now.
 *         (#^.^#)
 */

public abstract class BaseFragment<P extends BasePresenter> extends MvpFragment<P> {
    @Override
    protected abstract P initPresenter();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
