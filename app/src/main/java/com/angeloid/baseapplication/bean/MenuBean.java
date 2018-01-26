package com.angeloid.baseapplication.bean;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 9:48 now.
 *         (#^.^#)
 */

public class MenuBean {
    private int menu_id;
    private String name;
    private int category_id;
    private int use_model;
    private int use_model_scan;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getUse_model() {
        return use_model;
    }

    public void setUse_model(int use_model) {
        this.use_model = use_model;
    }

    public int getUse_model_scan() {
        return use_model_scan;
    }

    public void setUse_model_scan(int use_model_scan) {
        this.use_model_scan = use_model_scan;
    }

    @Override
    public String toString() {
        return "menu_id -> " + menu_id
                + " name -> " + name
                + " category_id -> " + category_id
                + " use_model -> " + use_model
                + " use_model_scan -> " + use_model_scan;
    }
}
