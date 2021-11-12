package com.example.cycle.Model.TAF;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("ceiling")
    @Expose
    private Ceiling ceiling;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("timestamp")
    @Expose
    private Timestamp timestamp;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("change")
    @Expose
    private Change change;
    @SerializedName("conditions")
    @Expose
    private List<Condition> conditions = null;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

}