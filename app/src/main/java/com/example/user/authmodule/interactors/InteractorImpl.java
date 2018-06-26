package com.example.user.authmodule.interactors;

import android.util.Base64;
import android.util.Log;
import android.util.Patterns;

import com.example.user.authmodule.app.ObscuraApi;
import com.example.user.authmodule.model.CommonRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 14.04.2018.
 */

public class InteractorImpl implements IBaseInteractor.IInteractor {
    protected ObscuraApi api;
    public InteractorImpl(ObscuraApi api) {
        this.api = api;
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    protected String encode(String gson) {
        Log.d("RETy", "InteractorImpl encode() gson " + gson);
        try {
            byte[] enc = gson.getBytes("UTF-8");
            String b64 = Base64.encodeToString(enc, Base64.URL_SAFE);
            b64 = b64.replace("\n", "");
            b64 = b64.replace("\t", "");
            b64 = b64.replace("\r", "");
            return b64;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.d("RETy", "InteractorImpl encode() UnsupportedEncodingException " + e.getMessage());
        }
        return null;
    }


    protected String decode(String gson) {
        Log.d("RETy", "InteractorImpl decode() gson " + gson);
        byte[] data = Base64.decode(gson, Base64.URL_SAFE);
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.d("RETy", "InteractorImpl decode() UnsupportedEncodingException " + e.getMessage());
        }
        return null;
    }

    protected String toJson(Object obj) throws NullPointerException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String mgson = gson.toJson(obj);
        return mgson;
    }

//    @Override
//    public Observable<String> doAuth(Context context, String action, String email, String password, String lang, String timeZone, String devId) {
//
//        AuthModel model = new AuthModel();
//        model.setAction(action);
//        model.setEmail(email);
//        model.setPassword(password);
//        model.setLang(lang);
//        model.setDevId(devId);
//        return Observable.just(model).flatMap(authModel -> {
//            Log.d("InteractorImpl", "Observable model to string " + authModel.toString());
//            if (isEmailValid(authModel.getEmail())) {
//                Log.d("InteractorImpl", "Valid email");
//                return Observable.just(authModel.getAction() + " success");
//            } else {
//                Log.d("InteractorImpl", "Invalid email");
//                return Observable.just(authModel.getEmail() + "is not valid");
//            }
//        });
//    }




    @Override
    public Observable<JsonObject> todoSingIn(String email, String password) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setEmail(email);
        commonRequest.setPassword(password);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signIn(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }

    @Override
    public Observable<JsonObject> todoSingUp(String email, String password) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setEmail(email);
        commonRequest.setPassword(password);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signUp(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }

    @Override
    public Observable<JsonObject> todoLogout() {
        CommonRequest commonRequest = new CommonRequest();

        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signUp(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }



    @Override
    public Observable<JsonObject> todoUploadUserImage(String action, String authKeyOrEmail, MultipartBody.Part part) {
        CommonRequest commonRequest = new CommonRequest();

        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signUp(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });    }

    @Override
    public Observable<JsonObject> todoRecoverAccount(Integer limit, Integer offset) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setLimit(limit);
        commonRequest.setOffset(offset);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.doRecoverAccount(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }


    @Override
    public Observable<JsonObject> todoGetUsersList(String email, String password) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setEmail(email);
        commonRequest.setPassword(password);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.getUsersList(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }

    @Override
    public Observable<JsonObject> todoEditProfile(Integer country_id, Integer state_id, Integer city_id, String name, String last_name, Integer image_id) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setCountry_id(country_id);
        commonRequest.setState_id(state_id);
        commonRequest.setCity_id(city_id);
        commonRequest.setName(name);
        commonRequest.setLastname(last_name);
        commonRequest.setImage_id(image_id);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signIn(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }

    @Override
    public Observable<JsonObject> todoGetCountriesList(Integer limit, Integer offset) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setLimit(limit);
        commonRequest.setOffset(offset);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signIn(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }

    @Override
    public Observable<JsonObject> todoGetStatesList(Integer country_id, Integer limit, Integer offset) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setCountry_id(country_id);
        commonRequest.setLimit(limit);
        commonRequest.setOffset(offset);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signIn(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }

    @Override
    public Observable<JsonObject> todoGetCitiesList(Integer state_id, Integer limit, Integer offset) {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setState_id(state_id);
        commonRequest.setLimit(limit);
        commonRequest.setOffset(offset);
        String json = this.toJson(commonRequest);
        String encode = this.encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encode+"}");
        return api.signIn(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    return new Gson().fromJson(json, JsonObject.class);
                });
    }
}