package com.example.user.authmodule.model;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by User on 08.05.2018.
 */

public class CommonRequest {
    public void setEmail(String email) {
        this.email = email;
    }

    private  String email;
    private  String password;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return last_name;
    }

    public void setLastname(String last_name) {
        this.last_name = last_name;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }

    private  Integer limit;
    private  Integer offset;
    private  Integer country_id;
    private  Integer state_id;
    private  Integer city_id;
    private  String name;
    private  String last_name;

    public String getMiddlename() {
        return middle_name;
    }

    public void setMiddlename(String middle_name) {
        this.middle_name = middle_name;
    }

    private String middle_name;
    private  Integer image_id;


    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");



    RequestBody body = RequestBody.create(mediaType, "a=foo&b=bar&c=wow&d=awesome&e=random&f=rainbows /* lots of strings */");

    public void setPassword(String password) {
        this.password = password;
    }


    public String toString() {
        return "CommonRequest{" +
                ", email=" + email +
                ", password=" + password +
                ", limit=" + limit +
                ", offset=" + offset +
                ", country_id=" + country_id +
                ", state_id=" + state_id +
                ", city_id=" + city_id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", image_id=" + image_id +
                '}';
    }
}
