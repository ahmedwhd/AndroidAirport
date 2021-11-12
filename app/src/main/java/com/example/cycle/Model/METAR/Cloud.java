package com.example.cycle.Model.METAR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("base_feet_agl")
    @Expose
    private Integer baseFeetAgl;
    @SerializedName("base_meters_agl")
    @Expose
    private Integer baseMetersAgl;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("feet")
    @Expose
    private Integer feet;
    @SerializedName("meters")
    @Expose
    private Integer meters;
    @SerializedName("text")
    @Expose
    private String text;

    public Integer getBaseFeetAgl() {
        return baseFeetAgl;
    }

    public void setBaseFeetAgl(Integer baseFeetAgl) {
        this.baseFeetAgl = baseFeetAgl;
    }

    public Integer getBaseMetersAgl() {
        return baseMetersAgl;
    }

    public void setBaseMetersAgl(Integer baseMetersAgl) {
        this.baseMetersAgl = baseMetersAgl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFeet() {
        return feet;
    }

    public void setFeet(Integer feet) {
        this.feet = feet;
    }

    public Integer getMeters() {
        return meters;
    }

    public void setMeters(Integer meters) {
        this.meters = meters;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}