package com.angeloid.baseapplication.view.event;

import com.angeloid.baseapplication.bean.TabType;

/**
 * @author yunjw
 *         Created at 2018/2/1.
 *         Time is 13:10 now.
 *         (#^.^#)
 */

public class UpdateNumberEvent {

    public UpdateNumberEvent(TabType tabType) {
        this.tabType = tabType;
    }

    private TabType tabType;
    private int number;

    public TabType getTabType() {
        return tabType;
    }

    public void setTabType(TabType tabType) {
        this.tabType = tabType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
