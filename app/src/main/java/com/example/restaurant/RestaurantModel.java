package com.example.restaurant;


import android.graphics.Bitmap;
import android.net.Uri;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="restaurants")
public class RestaurantModel {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String imageResId;
    private String title;
    private String description;
    private String longDescription;
    private String review;
    private String expensive;
    private String location;
    private String url;

    public RestaurantModel( String imageResId, String title, String description,String longDescription, String review, String expensive, String location, String url) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.longDescription = longDescription;
        this.review = review;
        this.expensive = expensive;
        this.location = location;
        this.url = url;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageResId() {
        return imageResId;
    }

    public void setImageResId(String imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String description) {
        this.longDescription = longDescription;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getExpensive() {
        return expensive;
    }

    public void setExpensive(String expensive) {
        this.expensive = expensive;
    }
}
