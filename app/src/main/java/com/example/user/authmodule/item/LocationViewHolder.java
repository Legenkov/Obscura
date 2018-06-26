package com.example.user.authmodule.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.authmodule.R;

import butterknife.BindView;

/**
 * Created by User on 19.06.2018.
 */

public class LocationViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_Title)

    protected TextView tvTitle;
    private  IItemListener listener;

    public LocationViewHolder(View itemView, IItemListener listener) {

        super(itemView);

}
    public void bind(Country country){
        tvTitle.setText(country.getTitle());

    }
}
