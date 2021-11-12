package com.example.cycle.Model.TAF;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Change {

    @SerializedName("indicator")
    @Expose
    private Indicator indicator;

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }

}