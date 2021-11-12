package com.example.cycle.Model.TAF;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TafData {

    @SerializedName("data")
    @Expose
    private List<TafDatum> data = null;
    @SerializedName("results")
    @Expose
    private Integer results;

    public List<TafDatum> getData() {
        return data;
    }

    public void setData(List<TafDatum> data) {
        this.data = data;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

}