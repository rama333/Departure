package com.labs.robots.departure.presenter;

import com.labs.robots.departure.model.ApiFactory;
import com.labs.robots.departure.model.ApiInterface;
import com.labs.robots.departure.model.DepartureModel;
import com.labs.robots.departure.view.DepartureView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeparturePresenter {
    ApiInterface apiInterface = ApiFactory.getRetrofitInstance("http://ramil-faxrut.myjino.ru/").create(ApiInterface.class);
    DepartureView departureView;

    private List<DepartureModel> departureModels = new ArrayList<>();


    public DeparturePresenter(DepartureView departureView) {
        this.departureView = departureView;
    }

    public void getDepartures(String zone){

        Call<DepartureModel> call = apiInterface.requestDepartures(zone);

        call.enqueue(new Callback<DepartureModel>() {
            @Override
            public void onResponse(Call<DepartureModel> call, Response<DepartureModel> response) {

                departureView.onDepartureSuccess(response.body().getDepartures());
            }

            @Override
            public void onFailure(Call<DepartureModel> call, Throwable t) {
                departureView.onDepartureFailed("error" + t.getMessage().toString());
            }
        });
    }

}
