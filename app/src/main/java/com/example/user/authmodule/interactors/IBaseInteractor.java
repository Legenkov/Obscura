package com.example.user.authmodule.interactors;

import android.content.Context;

import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MultipartBody;
import rx.Observable;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public interface IBaseInteractor {
    interface IInteractor extends IBaseInteractor {
        Observable<String> doAuth(Context context, String action, String email, String password, String language, String timeZone, String deviceId);
        Observable<JsonObject> uploadGalleryFiles(String action, String authKeyOrEmail, List<MultipartBody.Part> part);
        Observable<JsonObject> uploadFile(String action, String authKeyOrEmail, MultipartBody.Part part);
        Observable<JsonObject> singIn(String email, String password);
    }
}
