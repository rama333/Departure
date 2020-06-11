package com.labs.robots.departure.view;

import com.labs.robots.departure.model.Departures;

import java.util.List;

public interface DepartureView {
    void onDepartureSuccess(List<Departures> departuresModel);
    void onDepartureFailed(String error);

}
