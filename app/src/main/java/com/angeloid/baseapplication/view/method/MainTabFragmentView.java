package com.angeloid.baseapplication.view.method;

import com.angeloid.baseapplication.bean.SearchResponseDetail;
import com.angeloid.mvplibrary.BaseView;

import java.util.List;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 12:45 now.
 *         (#^.^#)
 */

public interface MainTabFragmentView extends BaseView {

    void setMainData(List<SearchResponseDetail> responseDetails);

    void setMainDataFailed(String code,String errorMsg);
}
