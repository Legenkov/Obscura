package com.example.user.authmodule.presenters;

import android.app.Application;

import com.example.user.authmodule.auth_operation.activities.AuthActivity;
import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.interactors.IBaseInteractor;
import com.example.user.authmodule.realm.IRealmUtils;
import com.example.user.authmodule.utils.networkCheck.INetworkCheck;
import com.example.user.authmodule.utils.validator.IValidator;

/**
 * Created by User on 06.02.2018.
 */

public class AuthPresenterImpl extends BasePresenter<IBaseView.IAuthView, IBaseInteractor.IInteractor>
        implements IPresenterContract.IAuthPresenter<IBaseView.IAuthView> {


    public AuthPresenterImpl(Application application, IBaseInteractor.IInteractor interactor) {
        this.application = application;
        this.interactor = interactor;
    }

    public AuthPresenterImpl(Application application, IBaseInteractor.IInteractor interactor, IValidator validator, INetworkCheck networkCheck, IRealmUtils realmUtils) {
        super();
        this.application = application;
        this.realmUtils = realmUtils;
    }


    @Override
    public void init(IBaseView.IAuthView view){
        super.init(view);
    }

    @Override
    public void doSignIn(String email, String password) {
        interactor.singIn( email,  password);

    }

    @Override
    public void doSignUp(String email, String phone, String password) {

    }

    @Override
    public void doRecoverAccount(String email) {

    }

    @Override
    public void doSocialAuth(AuthActivity activity, int type) {

    }



    @Override
    public void dismiss() {
        super.dismiss();
    }
}