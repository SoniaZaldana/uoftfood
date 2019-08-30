package com.uoft.food.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodProvider {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("building_id")
    @Expose
    private String buildingId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("short_name")
    @Expose
    private String shortName;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("campus")
    @Expose
    private String campus;

    @SerializedName("lat")
    @Expose
    private Double lat;

    @SerializedName("lng")
    @Expose
    private Double lng;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("hours")
    @Expose
    private Hours hours;

    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

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