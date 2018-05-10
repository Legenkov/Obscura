package com.example.user.authmodule.presenters;

import android.app.Application;

import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.interactors.IBaseInteractor;
import com.example.user.authmodule.realm.IRealmUtils;
import com.example.user.authmodule.realm.UserRealm;

/**
 * Created by User on 18.04.2018.
 */

public class SplashPresenterImpl extends BasePresenter<IBaseView.ISplashView, IBaseInteractor.IInteractor>
        implements IPresenterContract.ISplashPresenter{

    public SplashPresenterImpl(Application application, IRealmUtils realmUtils) {
        this.application = application;
        this.realmUtils = realmUtils;
    }

    @Override
    public void init(IBaseView.ISplashView v) {
        super.init(v);
    }

    @Override
    public void doCheckUserData() {
        realmUtils.getObject(1, UserRealm.class).subscribe(user ->{
            view.checkUserData(user != null);
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}