package com.angeloid.baseapplication.base;

import android.os.Bundle;

import com.angeloid.mvplibrary.BasePresenter;
import com.angeloid.mvplibrary.MvpActivity;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 */

public abstract class BaseActivity<P extends BasePresenter> extends MvpActivity<P> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 在子类中初始化对应的presenter
     *
     * @return 相应的presenter
     */
    @Override
    protected abstract P initPresenter();

    @Override
    public void showLoading() {
        ToastUtils.showShort("showLoading");
    }

    @Override
    public void hideLoading() {
        ToastUtils.showShort("hideLoading");
    }
}
