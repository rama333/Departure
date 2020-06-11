package com.labs.robots.departure.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.labs.robots.departure.R;
import com.labs.robots.departure.model.Departures;
import com.labs.robots.departure.view.MainActivity;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DepartureAdapter extends RecyclerView.Adapter<DepartureAdapter.ViewHolderDeparture> {

    List<Departures> departures;
    Context context;

    public DepartureAdapter(List<Departures> departures, Context context) {
        this.departures = departures;
        this.context = context;
    }

    @Override
    public ViewHolderDeparture onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = layoutInflater.inflate(R.layout.departure, viewGroup, false);

        return new ViewHolderDeparture(rowView);
    }

    @Override
    public void onBindViewHolder(ViewHolderDeparture viewHolderDeparture, int i) {
        String tt=  departures.get(i).getAddres().replaceAll("\n", " ");

        viewHolderDeparture.name.setText("Имя :  " + departures.get(i).getName());
        viewHolderDeparture.addres.setText("Адрес :  " + tt);
        viewHolderDeparture.services.setText("Услуги :  " + departures.get(i).getServices());
        viewHolderDeparture.time.setText("Время :  " + departures.get(i).getTime());


        viewHolderDeparture.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        });

    }

    public void add(int i, List<Departures> list) {

        Collections.reverse(list);

        departures.addAll(i, list);
        notifyItemRangeChanged(i, list.size());
    }


    @Override
    public int getItemCount() {
        return departures.size();
    }

    public class ViewHolderDeparture extends  RecyclerView.ViewHolder {
        @BindView(R.id.textName)
        TextView name;
        @BindView(R.id.textAddres)
        TextView addres;
        @BindView(R.id.textSer)
        TextView services;
        @BindView(R.id.textTime)
        TextView time;
        @BindView(R.id.card_view)
        CardView cardView;

        public ViewHolderDeparture(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
