package com.angeloid.baseapplication.bean;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 * 首页的tab标签对应接口的数字
 */

public enum TabType {
    PHONE(2),
    PAD(0),
    ROBOT(1),
    ALL(120);
    private int typeNum;
    TabType(int typeNum) {
        this.typeNum = typeNum;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }
}
