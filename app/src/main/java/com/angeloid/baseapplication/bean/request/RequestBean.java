package com.angeloid.baseapplication.bean.request;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 9:58 now.
 *         (#^.^#)
 */

public class RequestBean {
    public RequestBean(int use_system) {
        this.use_system = use_system;
    }

    private int use_system;

    public int getUse_system() {
        return use_system;
    }

    public void setUse_system(int use_system) {
        this.use_system = use_system;
    }
}
