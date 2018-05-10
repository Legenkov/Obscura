package com.example.user.authmodule.common;

/**
 * Created by User on 14.04.2018.
 */

import com.example.user.authmodule.model.Event;

import java.util.List;


public interface IMainListener {
    void getFeed(IMainListener.IDashboardCallback callback);


    interface IDashboardCallback {
        void showFeed(List<Event> events);
        void showEmptyList();
    }
}
