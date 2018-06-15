package com.seoho.jeaproto.model;

import java.util.Objects;

public class SubjectModel {

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
        SubjectModel that = (SubjectModel) o;
        return position == that.position &&
                Objects.equals(title, that.title);
    }

    @Override
    public String toString() {
        return "SubjectModel{" +
                "title='" + title + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, position);
    }
}
