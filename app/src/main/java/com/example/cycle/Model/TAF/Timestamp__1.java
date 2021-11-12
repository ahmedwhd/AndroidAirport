package com.example.cycle.Model.TAF;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timestamp__1 {

    @SerializedName("bulletin")
    @Expose
    private String bulletin;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("issued")
    @Expose
    private String issued;
    @SerializedName("to")
    @Expose
    private String to;

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}