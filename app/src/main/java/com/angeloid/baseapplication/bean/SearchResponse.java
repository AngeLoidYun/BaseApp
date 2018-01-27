package com.angeloid.baseapplication.bean;

import java.util.List;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 16:19 now.
 *         (#^.^#)
 */

public class SearchResponse {
    /**
     * 数据集
     */
    private List<SearchResponseDetail> data_list;
    /**
     * 总条数
     */
    private int count_num;
    /**
     * 每页显示条数
     */
    private int limit;
    /**
     * 总页数
     */
    private int page_num;
    /**
     * 当前第几页
     */
    private int page;

    public List<SearchResponseDetail> getData_list() {
        return data_list;
    }

    public void setData_list(List<SearchResponseDetail> data_list) {
        this.data_list = data_list;
    }

    public int getCount_num() {
        return count_num;
    }

    public void setCount_num(int count_num) {
        this.count_num = count_num;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage_num() {
        return page_num;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
