package com.uoft.food.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hours {

    @SerializedName("sunday")
    @Expose
    public Day sunday;

    @SerializedName("monday")
    @Expose
    public Day monday;

    @SerializedName("tuesday")
    @Expose
    public Day tuesday;

    @SerializedName("wednesday")
    @Expose
    public Day wednesday;

    @SerializedName("thursday")
    @Expose
    public Day thursday;

    @SerializedName("friday")
    @Expose
    public Day friday;

    @SerializedName("saturday")
    @Expose
    public Day saturday;

    public Day getSunday() {

        return sunday;
    }

    public Day getMonday() {
        return monday;
    }

    public Day getTuesday() {
        return tuesday;
    }

    public Day getWednesday() {
        return wednesday;
    }

    public Day getThursday() {
        return thursday;
    }

    public Day getFriday() {
        return friday;
    }

    public Day getSaturday() {
        return saturday;
    }
}