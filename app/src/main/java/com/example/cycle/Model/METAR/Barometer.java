package com.example.cycle.Model.METAR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Barometer {

    @SerializedName("hg")
    @Expose
    private Double hg;
    @SerializedName("hpa")
    @Expose
    private Double hpa;
    @SerializedName("kpa")
    @Expose
    private Double kpa;
    @SerializedName("mb")
    @Expose
    private Double mb;

    public Double getHg() {
        return hg;
    }

    public void setHg(Double hg) {
        this.hg = hg;
    }

    public Double getHpa() {
        return hpa;
    }

    public void setHpa(Double hpa) {
        this.hpa = hpa;
    }

    public Double getKpa() {
        return kpa;
    }

    public void setKpa(Double kpa) {
        this.kpa = kpa;
    }

    public Double getMb() {
        return mb;
    }

    public void setMb(Double mb) {
        this.mb = mb;
    }

}