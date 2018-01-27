package com.angeloid.baseapplication.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angeloid.baseapplication.R;
import com.angeloid.baseapplication.base.BaseFragment;
import com.angeloid.baseapplication.customview.SelectBar;
import com.angeloid.baseapplication.customview.SelectBarTab;
import com.angeloid.baseapplication.presenter.MainFragmentPresenter;
import com.angeloid.baseapplication.view.method.MainFragmentView;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 19:39 now.
 *         (#^.^#)
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentView{

    private SupportFragment[] mFragments = new SupportFragment[4];
    public static final int PHONE = 0;
    public static final int PAD = 1;
    public static final int ROBOT = 2;
    public static final int ALL = 3;
    //******************************view开始*********************************
    /**
     * 中部选择bar
     */
    private SelectBar mSelectBar;
    //******************************view结束*********************************

    @Override
    protected MainFragmentPresenter initPresenter() {
        return new MainFragmentPresenter(this);
    }

    public static MainFragment newInstance(){
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        initView(view);
        return view;
    }

    private void initView(View rootView) {
        mSelectBar = rootView.findViewById(R.id.mainf_selectbar);
        mSelectBar.addItem(new SelectBarTab(_mActivity,getString(R.string.pad)))
                .addItem(new SelectBarTab(_mActivity,getString(R.string.phone)))
                .addItem(new SelectBarTab(_mActivity,getString(R.string.robot)))
                .addItem(new SelectBarTab(_mActivity,getString(R.string.whole)));

        mSelectBar.setOnTabSelectedListener(new SelectBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position],mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(MainPhoneFragment.class);
        if(firstFragment == null){
            mFragments[PHONE] = MainPhoneFragment.newInstance();
            mFragments[PAD] = MainPadFragment.newInstance();
            mFragments[ROBOT] = MainRobotFragment.newInstance();
            mFragments[ALL] = MainAllFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_select_tab_container,PHONE,
                    mFragments[PHONE],
                    mFragments[PAD],
                    mFragments[ROBOT],
                    mFragments[ALL]);
        }else{
            mFragments[PHONE] = firstFragment;
            mFragments[PAD] = findChildFragment(MainPadFragment.class);
            mFragments[ROBOT] = findChildFragment(MainRobotFragment.class);
            mFragments[ALL] = findChildFragment(MainAllFragment.class);
        }
    }

}
