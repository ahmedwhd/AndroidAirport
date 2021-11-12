package com.example.cycle.Model.METAR;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("barometer")
    @Expose
    private Barometer barometer;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("dewpoint")
    @Expose
    private Dewpoint dewpoint;
    @SerializedName("elevation")
    @Expose
    private Elevation elevation;
    @SerializedName("flight_category")
    @Expose
    private String flightCategory;
    @SerializedName("humidity")
    @Expose
    private Humidity humidity;
    @SerializedName("icao")
    @Expose
    private String icao;
    @SerializedName("observed")
    @Expose
    private String observed;
    @SerializedName("raw_text")
    @Expose
    private String rawText;
    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("windchill")
    @Expose
    private Windchill windchill;
    @SerializedName("ceiling")
    @Expose
    private Ceiling ceiling;

    public Ceiling getCeiling() {
        return ceiling;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public Barometer getBarometer() {
        return barometer;
    }

    public void setBarometer(Barometer barometer) {
        this.barometer = barometer;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(Dewpoint dewpoint) {
        this.dewpoint = dewpoint;
    }

    public Elevation getElevation() {
        return elevation;
    }

    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    public String getFlightCategory() {
        return flightCategory;
    }

    public void setFlightCategory(String flightCategory) {
        this.flightCategory = flightCategory;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getObserved() {
        return observed;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
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

    public Windchill getWindchill() {
        return windchill;
    }

    public void setWindchill(Windchill windchill) {
        this.windchill = windchill;
    }

}