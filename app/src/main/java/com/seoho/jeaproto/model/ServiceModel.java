package com.seoho.jeaproto.model;

import java.util.Objects;

public class ServiceModel {

    private String title;
    private String date;
    private String IMG_Url;

    @Override
    public String toString() {
        return "ServiceModel{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", IMG_Url='" + IMG_Url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceModel that = (ServiceModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(date, that.date) &&
                Objects.equals(IMG_Url, that.IMG_Url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, date, IMG_Url);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIMG_Url() {
        return IMG_Url;
    }

    public void setIMG_Url(String IMG_Url) {
        this.IMG_Url = IMG_Url;
    }
}
