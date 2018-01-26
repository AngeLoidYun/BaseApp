package com.angeloid.baseapplication.view.method;

import com.angeloid.baseapplication.bean.CategoryBean;
import com.angeloid.mvplibrary.BaseView;

/**
 * @author yunjw
 *         Created at 2018/1/25.
 *         Time is 10:35 now.
 *         (#^.^#)
 */

public interface MainView extends BaseView {
    void showAppDetail(CategoryBean categoryBean);
    void showToast(String string);
}
