package com.seoho.jeaproto.model;

import java.util.Objects;

public class MenuModel {

    private String title;
    private int position;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuModel menuModel = (MenuModel) o;
        return position == menuModel.position &&
                Objects.equals(title, menuModel.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, position);
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "title='" + title + '\'' +
                ", position=" + position +
                '}';
    }
}
