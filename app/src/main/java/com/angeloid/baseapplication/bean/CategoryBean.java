package com.angeloid.baseapplication.bean;

import java.util.List;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 9:47 now.
 *         (#^.^#)
 */

public class CategoryBean {
    private int category_id;
    private int model_id;
    private String letter_mark;
    private String name;
    private List<MenuBean> menu_list;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getLetter_mark() {
        return letter_mark;
    }

    public void setLetter_mark(String letter_mark) {
        this.letter_mark = letter_mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuBean> getMenu_list() {
        return menu_list;
    }

    public void setMenu_list(List<MenuBean> menu_list) {
        this.menu_list = menu_list;
    }

    @Override
    public String toString() {
        return " category_id -> " + category_id
                + " model_id -> " + model_id
                + " letter_mark -> " + letter_mark
                + " name -> " + name
                + " menu_list ->" + menu_list.toString();
    }
}
