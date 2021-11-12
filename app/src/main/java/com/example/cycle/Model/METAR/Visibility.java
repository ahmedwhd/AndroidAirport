package com.example.cycle.Model.METAR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visibility {

    @SerializedName("meters")
    @Expose
    private String meters;
    @SerializedName("meters_float")
    @Expose
    private Integer metersFloat;
    @SerializedName("miles")
    @Expose
    private String miles;
    @SerializedName("miles_float")
    @Expose
    private Double milesFloat;

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public Integer getMetersFloat() {
        return metersFloat;
    }

    public void setMetersFloat(Integer metersFloat) {
        this.metersFloat = metersFloat;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public Double getMilesFloat() {
        return milesFloat;
    }

    public void setMilesFloat(Double milesFloat) {
        this.milesFloat = milesFloat;
    }

}