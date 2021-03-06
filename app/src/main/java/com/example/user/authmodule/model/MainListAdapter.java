package com.example.user.authmodule.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.authmodule.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 03.05.2018.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListElementHolder> {

    private List<Event> mEvents = new ArrayList<>();
    private Context mContext;
    private ItemListener<Event> mListener;

    public MainListAdapter(Context ctx, ItemListener<Event> listener) {
        mContext = ctx;
        mListener = listener;
    }

    @Override
    public MainListElementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);

        return new MainListElementHolder(mContext, mListener, v);
    }

    @Override
    public void onBindViewHolder(MainListElementHolder holder, int position) {
        holder.bindMainListElement(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public void addItem(Event item) {
        mEvents.add(item);
        notifyDataSetChanged();
    }

    public void addItems(Event[] items) {
        mEvents.addAll(Arrays.asList(items));
        notifyDataSetChanged();
    }

    public void removeItem(Event item) {
        mEvents.remove(item);
        notifyDataSetChanged();
    }
}