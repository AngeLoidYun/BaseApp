package com.angeloid.baseapplication.view.fragment;

import android.os.Bundle;

import com.angeloid.baseapplication.bean.TabType;
import com.angeloid.baseapplication.presenter.MainTabFragmentPresenter;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 13:18 now.
 *         (#^.^#)
 */

public class MainAllFragment extends BaseMainTabFragment<MainTabFragmentPresenter>  {
    @Override
    protected MainTabFragmentPresenter initPresenter() {
        return new MainTabFragmentPresenter(this);
    }

    @Override
    protected TabType initTabType() {
        return TabType.ALL;
    }


    public static MainAllFragment newInstance() {
        Bundle args = new Bundle();
        MainAllFragment fragment = new MainAllFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
