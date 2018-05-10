package com.example.user.authmodule.auth_operation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.user.authmodule.R;
import com.example.user.authmodule.activities.MainActivity;
import com.example.user.authmodule.app.ObscuraApp;
import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.presenters.IPresenterContract;

import javax.inject.Inject;


public class SplashActivity extends AppCompatActivity implements IBaseView.ISplashView {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Inject
    IPresenterContract.ISplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);
        ObscuraApp.get(this).getAppComponent().inject(this);
        presenter.init(this);
        presenter.doCheckUserData(); // todo 1
    }

    @Override
    public void checkUserData(boolean isLoggedIn) {
        if(isLoggedIn){
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }, SPLASH_DISPLAY_LENGTH);

        }else {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, NavigationActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }, SPLASH_DISPLAY_LENGTH);
        }
    }

    @Override
    public void showMessage(String s) {

    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }


}