package com.example.user.authmodule.model;

import io.realm.RealmObject;

/**
 * Created by User on 26.04.2018.
 */

public class Owner extends RealmObject {
    private String name;
    private String url;

    public Owner() {

    }

    public Owner(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}