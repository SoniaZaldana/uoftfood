package com.uoft.food.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("closed")
    @Expose
    public Boolean closed;
    @SerializedName("open")
    @Expose
    public Integer open;
    @SerializedName("close")
    @Expose
    public Integer close;

}
