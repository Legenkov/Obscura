package com.example.user.authmodule.model;

/**
 * Created by User on 03.05.2018.
 */

public interface ItemListener<T> {
    void open(T item);
    void remove(T item);
}
