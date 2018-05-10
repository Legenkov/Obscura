package com.example.user.authmodule.common;

import com.example.user.authmodule.model.Event;

import java.util.List;

/**
 * Created by User on 26.04.2018.
 */

public interface IDashboardCallback {
    void showFeed(List<Event> list);
    void showEmptyList();
}
