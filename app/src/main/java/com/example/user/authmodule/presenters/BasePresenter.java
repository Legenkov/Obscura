package com.example.user.authmodule.presenters;

import android.app.Application;

import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.interactors.IBaseInteractor;
import com.example.user.authmodule.realm.IRealmUtils;
import com.example.user.authmodule.utils.networkCheck.INetworkCheck;
import com.example.user.authmodule.utils.validator.IValidator;

/**
 * Created by User on 06.02.2018.
 */

public abstract class BasePresenter<V extends IBaseView, I extends IBaseInteractor> {
    protected V view;
    protected I interactor;

    protected Application application;
    protected IValidator validator;
    protected INetworkCheck networkCheck;
    protected IBaseInteractor.IInteractor baseInteractor;
    protected IRealmUtils realmUtils;


    protected void init(V view) {
        this.view = view;
    }

    protected void dismiss() {
        this.view = null;
    }
}
