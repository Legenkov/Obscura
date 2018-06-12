package com.example.user.authmodule.presenters;

import com.example.user.authmodule.common.IBaseView;

import java.io.File;

/**
 * Created by User on 28.04.2018.
 */

public interface IPresenterContract  {

    interface IAuthPresenter<V extends IBaseView.IAuthView>
            extends IPresenterContract {
        void doSignIn(String email, String password);
        void doSingUp(String email, String password);
        void doRecoverAccount (String email);;




    }

    interface ISplashPresenter<V extends IBaseView.ISplashView> {
        void init(V v);
        void doCheckUserData(); // todo 1 где вызывается?
    }

    interface IMainPresenter<V extends IBaseView.IMainView> {
        void doLogout();
        void doGetFile(File file);
        void doGetUsersList(Integer limit, Integer offset);
        void doEditProfile(Integer  country_id, Integer  state_id, Integer  city_id, String name, String last_name, Integer  image_id);


    }
    interface IDetailPresenter<V extends IBaseView.IDetailView> {
        void doUploadUserImage();
        void doGetCountriesList(Integer limit, Integer  offset);
        void doGetStatesList(Integer  country_id,Integer  limit, Integer  offset);
        void doGetCitiesList(Integer  state_id,Integer  limit, Integer  offset);
    }
}