package com.angeloid.baseapplication.view.fragment;

import android.os.Bundle;

import com.angeloid.baseapplication.presenter.MainTabFragmentPresenter;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 13:12 now.
 *         (#^.^#)
 */

public class MainPadFragment extends BaseMainTabFragment<MainTabFragmentPresenter>{
    @Override
    protected MainTabFragmentPresenter initPresenter() {
        return new MainTabFragmentPresenter(this);
    }

    public static MainPadFragment newInstance() {
        Bundle args = new Bundle();
        MainPadFragment fragment = new MainPadFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
