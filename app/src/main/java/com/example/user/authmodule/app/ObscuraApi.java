package com.example.user.authmodule.app;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by User on 03.05.2018.
 */

public interface ObscuraApi {

//    @POST("/sign_in")
//    Observable<Response<ResponseBody>> simpleRequest(@Header("Content-Type") String contentType,
//                                                     @Header("action") String action,
//                                                     @Header("authkey") String token,
//                                                     @Header("Accept-Language") String Language,
//                                                     @Header("time-zone") String timeZone,
//                                                     @Body RequestBody body);

    @Multipart
    @POST
    Observable<ResponseBody> uploadFile(@Header("action") String action,
                                        @Header("authkey") String token,
                                        @Part MultipartBody.Part avatar);

    @Multipart
    @POST
    Observable<ResponseBody> uploadArrayPostFiles(@Header("action") String action,
                                                  @Header("authkey") String token,
                                                  @Part List<MultipartBody.Part> file);

//   @FormUrlEncoded
//    @POST("/sign_in")
//    Observable<Response<ResponseBody>> signIn(@Body RequestBody body);

    @POST("/sign_in")
    Observable<Response<ResponseBody>>  signIn (@Body RequestBody body);

    @POST("/logout")
    Observable<Response<ResponseBody>>  logout (@Body RequestBody body);

    @POST("/sign_up")
    Observable<Response<ResponseBody>>  signUp (@Body RequestBody body);

    @POST("/password/email")
    Observable<Response<ResponseBody>>  doRecoverAccount (@Body RequestBody body);

    @POST("/users/list")
    Observable<Response<ResponseBody>>  getUsersList (@Body RequestBody body);

    @POST("/countries")
    Observable<Response<ResponseBody>>  getCountriesList (@Body RequestBody body);

    @POST("/states/{id}")
    Observable<Response<ResponseBody>>  getRegionsList (@Body RequestBody body);

    @POST("/cities/{id}")
    Observable<Response<ResponseBody>>  getCityList (@Body RequestBody body);

    @POST("/user/update")
    Observable<Response<ResponseBody>>  editProfile (@Body RequestBody body);

    @POST("/image/upload")
    Observable<Response<ResponseBody>>  uploadUserImage (@Body RequestBody body);



}
