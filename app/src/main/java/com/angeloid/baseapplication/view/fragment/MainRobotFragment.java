package com.angeloid.baseapplication.view.fragment;

import android.os.Bundle;

import com.angeloid.baseapplication.bean.TabType;
import com.angeloid.baseapplication.presenter.MainTabFragmentPresenter;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 13:16 now.
 *         (#^.^#)
 */

public class MainRobotFragment extends BaseMainTabFragment<MainTabFragmentPresenter> {
    @Override
    protected MainTabFragmentPresenter initPresenter() {
        return new MainTabFragmentPresenter(this);
    }

    @Override
    protected TabType initTabType() {
        return TabType.ROBOT;
    }

    public static MainRobotFragment newInstance() {
        Bundle args = new Bundle();
        MainRobotFragment fragment = new MainRobotFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
