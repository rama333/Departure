package com.labs.robots.departure.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DepartureModel implements Serializable {

    @SerializedName("error")
    String error;
    @SerializedName("message")
    String message;
    @SerializedName("departures")
    List<Departures> departures;

    public DepartureModel(String error, String message, List<Departures> departures) {
        this.error = error;
        this.message = message;
        this.departures = departures;
    }


    public String isError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Departures> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departures> departures) {
        this.departures = departures;
    }
}
