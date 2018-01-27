package com.angeloid.baseapplication.view.method;

import com.angeloid.baseapplication.bean.request.SearchRequest;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 16:07 now.
 *         (#^.^#)
 */

public interface TabFragmentFetchData {
    /**
     * 获取初始数据
     *
     * @param searchOriginRequest
     */
    public void fetchOriginData(SearchRequest searchOriginRequest);

    /**
     * 获取更多数据
     *
     * @param searchMoreRequest
     */
    public void fetchMoreData(SearchRequest searchMoreRequest);
}
