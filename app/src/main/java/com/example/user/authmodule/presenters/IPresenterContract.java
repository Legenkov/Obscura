package com.example.user.authmodule.presenters;

import android.content.Intent;

import com.example.user.authmodule.auth_operation.activities.AuthActivity;
import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.common.IMainListener;

/**
 * Created by User on 28.04.2018.
 */

public interface IPresenterContract {
    void dismiss();

    interface IAuthPresenter<V extends IBaseView.IAuthView>
            extends IPresenterContract {

        void init(V v);
        void doSignIn(String email, String password);
        void doSignUp(String email, String phone, String password);
        void doRecoverAccount(String email);
        void doSocialAuth(AuthActivity activity, int type);
    }

    interface ISplashPresenter<V extends IBaseView.ISplashView> {
        void init(V v);
        void doCheckUserData();
    }

    interface IMainPresenter<V extends IBaseView.IMainView> {
        void doLogout(String token, int type);
        void doGetFeed(IMainListener.IDashboardCallback callback);
        void onActivityResult(int requestCode, int resultCode, Intent data);
        void init(V view);
        void dismiss();
    }
}