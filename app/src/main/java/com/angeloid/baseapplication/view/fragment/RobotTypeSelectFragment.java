package com.angeloid.baseapplication.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author yunjw
 *         Created at 2018/2/1.
 *         Time is 17:51 now.
 *         (#^.^#)
 */

public class RobotTypeSelectFragment extends SupportFragment {
    public static RobotTypeSelectFragment newInstance() {
        Bundle args = new Bundle();
        RobotTypeSelectFragment fragment = new RobotTypeSelectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
