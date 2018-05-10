package com.example.user.authmodule.interactors;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by User on 08.05.2018.
 */

public class CommonRequest {
    private  String email;
    private  String password;
    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

    RequestBody body = RequestBody.create(mediaType, "a=foo&b=bar&c=wow&d=awesome&e=random&f=rainbows /* lots of strings */");


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
