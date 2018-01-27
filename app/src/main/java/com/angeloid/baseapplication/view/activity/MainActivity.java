package com.angeloid.baseapplication.view.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.angeloid.baseapplication.R;
import com.angeloid.baseapplication.base.BaseActivity;
import com.angeloid.baseapplication.presenter.MainPresenter;
import com.angeloid.baseapplication.view.fragment.MainFragment;
import com.angeloid.baseapplication.view.method.MainActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends BaseActivity<MainPresenter> implements MainActivityView {
    @BindView(R.id.fl_container)
    FrameLayout mainContainer;


    void getApp() {
        presenter.getAppData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(findFragment(MainFragment.class) == null){
            loadRootFragment(R.id.fl_container,MainFragment.newInstance());
        }
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
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
