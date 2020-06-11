package com.labs.robots.departure.view;

import android.os.Bundle;
import android.widget.Toast;

import com.labs.robots.departure.R;
import com.labs.robots.departure.model.Departures;
import com.labs.robots.departure.presenter.DeparturePresenter;
import com.labs.robots.departure.view.adapters.DepartureAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DepartureMain extends AppCompatActivity implements DepartureView {

    DeparturePresenter departurePresenter;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    DepartureAdapter departureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        departurePresenter = new DeparturePresenter(this);

        departurePresenter.getDepartures("kues");

        List<Departures> departures = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        departureAdapter = new DepartureAdapter(departures, this);

        recyclerView.setAdapter(departureAdapter);
    }


    @Override
    public void onDepartureSuccess(List<Departures> departuresModel) {

        if(!departuresModel.isEmpty()) {

            departureAdapter.add(0, departuresModel);

        }

    }

    @Override
    public void onDepartureFailed(String error) {

        Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();

    }
}