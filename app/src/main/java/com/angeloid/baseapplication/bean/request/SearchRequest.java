package com.angeloid.baseapplication.bean.request;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 15:54 now.
 *         (#^.^#)
 */

public class SearchRequest {
    /**
     * 分类（系列）编号
     */
    private int category_id;
    /**
     * 模糊查询  搜索app名称
     */
    private String app_name;
    /**
     * 适用系统（1.android 2.ios）
     */
    private int use_system;
    /**
     * 安装位置（0.pad 1.机器人 2.手机 120.全部）
     */
    private int install_position;
    /**
     * 小类型
     */
    private int use_model;
    /**
     * 每页显示条数   默认10条
     */
    private int page_num;
    /**
     * 页数
     */
    private int page;

    public SearchRequest(int category_id, int use_model) {
        this.category_id = category_id;
        this.use_model = use_model;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public int getUse_system() {
        return use_system;
    }

    public void setUse_system(int use_system) {
        this.use_system = use_system;
    }

    public int getInstall_position() {
        return install_position;
    }

    public void setInstall_position(int install_position) {
        this.install_position = install_position;
    }

    public int getUse_model() {
        return use_model;
    }

    public void setUse_model(int use_model) {
        this.use_model = use_model;
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
