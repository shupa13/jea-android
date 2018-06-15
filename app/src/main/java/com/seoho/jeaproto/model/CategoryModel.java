package com.seoho.jeaproto.model;

import java.util.Objects;

public class CategoryModel {

    private int positon;
    private String title;

    public int getPositon() {
        return positon;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return positon == that.positon &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(positon, title);
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "positon=" + positon +
                ", title='" + title + '\'' +
                '}';
    }
}
