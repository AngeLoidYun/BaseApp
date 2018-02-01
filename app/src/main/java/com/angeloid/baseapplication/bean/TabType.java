package com.angeloid.baseapplication.bean;

import com.angeloid.baseapplication.R;

/**
 * Created by Angeloid
 * email:angeloidYun@gmail.com
 * wechat:flydexin
 * 首页的tab标签对应接口的数字
 */

public enum TabType {
    PHONE(2, R.string.pad,0),
    PAD(0,R.string.phone,1),
    ROBOT(1,R.string.robot,2),
    ALL(120,R.string.whole,3);
    private int typeNumToServer;
    private int typeNumString;
    private int index;
    TabType(int typeNumToServer,int typeNumString,int index) {
        this.typeNumToServer = typeNumToServer;
        this.typeNumString = typeNumString;
        this.index = index;
    }

    public int getTypeNumToServer() {
        return typeNumToServer;
    }

    public int getTypeNumString() {
        return typeNumString;
    }

    public int getIndex() {
        return index;
    }
}
