package com.angeloid.baseapplication.view.method;

import com.angeloid.baseapplication.bean.response.SearchResponseDetail;
import com.angeloid.mvplibrary.BaseView;

import java.util.List;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 12:45 now.
 *         (#^.^#)
 */

public interface MainTabFragmentView extends BaseView {
    /**
     * 设置首批数据成功
     * @param responseDetails 数据
     */
    void setOriginData(List<SearchResponseDetail> responseDetails);

    /**
     * 设置首批数据失败
     * @param code 错误码
     * @param errorMsg 错误信息
     */
    void setOriginDataFailed(String code,String errorMsg);
}
