package com.seoho.jeaproto.model;

import java.util.Objects;

public class BannerModel {
    String imageUrl;
    String query;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BannerModel that = (BannerModel) o;
        return Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(query, that.query);
    }

    @Override
    public int hashCode() {

        return Objects.hash(imageUrl, query);
    }

    @Override
    public String toString() {
        return "BannerModel{" +
                "imageUrl='" + imageUrl + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}