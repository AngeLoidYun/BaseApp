package com.angeloid.baseapplication;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 17:39 now.
 *         (#^.^#)
 */

public class GlobalConfig {
    /**
     * 每一次刷新加载的项目个数
     */
    public static int ITEM_PER_PAGE = 10;

    public static String BASE_URL_FORE = "http://10.100.2.32/api/";
    public static String BASE_URL = BASE_URL_FORE+"v3/apps/";
    public static String BASE_URL_OLD = BASE_URL_FORE+"v2/apps/";


    public static int CURRENT_ROBOT_TYPE;
    public static int CURRENT_ROBOT_TYPE_SMALL;
}
