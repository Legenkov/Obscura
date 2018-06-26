package com.example.user.authmodule.item;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.authmodule.R;

import java.util.List;

/**
 * Created by User on 19.06.2018.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    private IItemListener listener;
    protected TextView tvTitle;
    private IItemListener iItemListener;
    List<Country> countryList;

    LocationAdapter(List<Country> countries){
        this.countryList = countryList;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_location, viewGroup, false);
        LocationViewHolder lvh = new LocationViewHolder(v, iItemListener);
        return lvh;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder locationViewHolder, int position) {
        locationViewHolder.bind(countryList.get(position));
    }







    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
