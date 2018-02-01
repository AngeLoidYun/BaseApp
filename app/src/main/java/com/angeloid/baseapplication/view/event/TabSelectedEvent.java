package com.angeloid.baseapplication.view.event;

/**
 * @author yunjw
 *         Created at 2018/2/1.
 *         Time is 17:04 now.
 *         (#^.^#)
 */

public class TabSelectedEvent {
    private int position;
    private boolean isReselect;

    public TabSelectedEvent(int position) {
        this.position = position;
    }

    public TabSelectedEvent(int position, boolean isReselect) {
        this.position = position;
        this.isReselect = isReselect;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isReselect() {
        return isReselect;
    }

    public void setReselect(boolean reselect) {
        isReselect = reselect;
    }
}
