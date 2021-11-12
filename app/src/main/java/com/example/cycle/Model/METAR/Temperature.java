package com.example.cycle.Model.METAR;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Temperature {

    @SerializedName("celsius")
    @Expose
    private Integer celsius;
    @SerializedName("fahrenheit")
    @Expose
    private Integer fahrenheit;

    public Integer getCelsius() {
        return celsius;
    }

    public void setCelsius(Integer celsius) {
        this.celsius = celsius;
    }

    public Integer getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(Integer fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

}