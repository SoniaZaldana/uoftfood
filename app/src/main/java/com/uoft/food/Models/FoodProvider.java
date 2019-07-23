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

}