package com.uoft.food.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodProvider {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("building_id")
    @Expose
    public String buildingId;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("short_name")
    @Expose
    public String shortName;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("campus")
    @Expose
    public String campus;

    @SerializedName("lat")
    @Expose
    public Double lat;

    @SerializedName("lng")
    @Expose
    public Double lng;

    @SerializedName("address")
    @Expose
    public String address;

    @SerializedName("hours")
    @Expose
    public Hours hours;

    @SerializedName("tags")
    @Expose
    public List<String> tags = null;

    public String getId() {
        return id;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getCampus() {
        return campus;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getAddress() {
        return address;
    }

    public Hours getHours() {
        return hours;
    }

    public List<String> getTags() {
        return tags;
    }
}