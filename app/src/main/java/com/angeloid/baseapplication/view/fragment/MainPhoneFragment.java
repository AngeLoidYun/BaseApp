package com.angeloid.baseapplication.view.fragment;

import android.os.Bundle;

import com.angeloid.baseapplication.presenter.MainTabFragmentPresenter;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 12:44 now.
 *         (#^.^#)
 */

public class MainPhoneFragment extends BaseMainTabFragment<MainTabFragmentPresenter>{
    @Override
    protected MainTabFragmentPresenter initPresenter() {
        return new MainTabFragmentPresenter(this);
    }

    public static MainPhoneFragment newInstance() {
        Bundle args = new Bundle();
        MainPhoneFragment fragment = new MainPhoneFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
