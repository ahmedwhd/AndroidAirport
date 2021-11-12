package com.example.cycle.Model.TAF;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TafDatum {

    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = null;
    @SerializedName("icao")
    @Expose
    private String icao;
    @SerializedName("raw_text")
    @Expose
    private String rawText;
    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("timestamp")
    @Expose
    private Timestamp__1 timestamp;

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
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

    public Timestamp__1 getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp__1 timestamp) {
        this.timestamp = timestamp;
    }

}