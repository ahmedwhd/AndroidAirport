package com.example.cycle.Model.METAR;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Wind {

    @SerializedName("degrees")
    @Expose
    private Integer degrees;
    @SerializedName("speed_kph")
    @Expose
    private Integer speedKph;
    @SerializedName("speed_kts")
    @Expose
    private Integer speedKts;
    @SerializedName("speed_mph")
    @Expose
    private Integer speedMph;
    @SerializedName("speed_mps")
    @Expose
    private Integer speedMps;

    public Integer getDegrees() {
        return degrees;
    }

    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }

    public Integer getSpeedKph() {
        return speedKph;
    }

    public void setSpeedKph(Integer speedKph) {
        this.speedKph = speedKph;
    }

    public Integer getSpeedKts() {
        return speedKts;
    }

    public void setSpeedKts(Integer speedKts) {
        this.speedKts = speedKts;
    }

    public Integer getSpeedMph() {
        return speedMph;
    }

    public void setSpeedMph(Integer speedMph) {
        this.speedMph = speedMph;
    }

    public Integer getSpeedMps() {
        return speedMps;
    }

    public void setSpeedMps(Integer speedMps) {
        this.speedMps = speedMps;
    }

}