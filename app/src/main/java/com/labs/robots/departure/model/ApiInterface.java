package com.labs.robots.departure.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/index.php?action=getDepartures")
    Call<DepartureModel> requestDepartures(@Field("zone") String zone
    );
}
