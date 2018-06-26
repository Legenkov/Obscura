package com.example.user.authmodule.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 21.06.2018.
 */

public class Country {
    Integer country_id;
    String title;

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    Country(Integer country_id, String title){
        this.country_id = country_id;
        this.title = title;
    }
    private List<Country> country;

    private void initCOuntry(){
        country = new ArrayList<>();
        country.add(new Country(1, "Ukraine"));
        country.add(new Country(2, "Russia"));
        country.add(new Country(3, "Poland"));
        country.add(new Country(4, "USA"));

    }
}