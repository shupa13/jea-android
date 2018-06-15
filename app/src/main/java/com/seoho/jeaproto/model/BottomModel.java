package com.seoho.jeaproto.model;

import java.util.Objects;

public class BottomModel {

    private int position;
    private String title;

    @Override
    public String toString() {
        return "BottomModel{" +
                "position=" + position +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BottomModel that = (BottomModel) o;
        return position == that.position &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, title);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
