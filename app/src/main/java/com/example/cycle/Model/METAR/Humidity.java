package com.example.cycle.Model.METAR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Humidity {

    @SerializedName("percent")
    @Expose
    private Integer percent;

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

}