package com.example.user.authmodule.interactors;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import rx.Observable;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public interface IBaseInteractor {
    interface IInteractor extends IBaseInteractor {
//        Observable<String> doAuth(Context context, String action, String email, String password, String language, String timeZone, String deviceId);
//        Observable<JsonObject> doUploadGalleryFiles(String action, String authKeyOrEmail, List<MultipartBody.Part> part);
//        Observable<JsonObject> doUploadFile(String action, String authKeyOrEmail, MultipartBody.Part part);
        Observable<JsonObject> todoSingIn(String email, String password);
        Observable<JsonObject> todoSingUp(String email, String password);
        Observable<JsonObject> todoLogout();
        Observable<JsonObject> todoUploadUserImage(String action, String authKeyOrEmail, MultipartBody.Part part);
        Observable<JsonObject> todoRecoverAccount(Integer limit, Integer offset);
        Observable<JsonObject> todoGetUsersList(String email, String password);
        Observable<JsonObject> todoEditProfile(Integer country_id,Integer state_id,Integer city_id, String name, String last_name, Integer image_id);
        Observable<JsonObject> todoGetCountriesList(Integer limit, Integer offset);
        Observable<JsonObject> todoGetStatesList(Integer country_id, Integer limit, Integer offset);
        Observable<JsonObject> todoGetCitiesList(Integer state_id, Integer limit, Integer offset);
    }

}
