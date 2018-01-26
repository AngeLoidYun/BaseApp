package com.angeloid.baseapplication.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.angeloid.baseapplication.R;
import com.angeloid.baseapplication.base.BaseActivity;
import com.angeloid.baseapplication.bean.CategoryBean;
import com.angeloid.baseapplication.presenter.MainPresenter;
import com.angeloid.baseapplication.view.method.MainView;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.btn_getapp)
    Button getApp;
    @BindView(R.id.tv_getapp)
    TextView tvGetApp;


    @OnClick(R.id.btn_getapp)
    void getApp() {
        presenter.getAppData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }


    @Override
    public void showAppDetail(CategoryBean categoryBean) {
        tvGetApp.setText(categoryBean.toString());
    }

    @Override
    public void showToast(String string) {
        ToastUtils.showShort(string);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
