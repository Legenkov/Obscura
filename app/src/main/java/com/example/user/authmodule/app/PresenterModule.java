package com.example.user.authmodule.app;

import android.app.Application;

import com.example.user.authmodule.interactors.IBaseInteractor;
import com.example.user.authmodule.presenters.AuthPresenterImpl;
import com.example.user.authmodule.presenters.IPresenterContract;
import com.example.user.authmodule.presenters.MainPresenterImpl;
import com.example.user.authmodule.presenters.SplashPresenterImpl;
import com.example.user.authmodule.realm.IRealmUtils;
import com.example.user.authmodule.utils.networkCheck.INetworkCheck;
import com.example.user.authmodule.utils.validator.IValidator;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @AppScope
    IPresenterContract.IAuthPresenter providesAuthPresenter(Application application, IBaseInteractor.IInteractor interactor,
                                                            IValidator validator, INetworkCheck networkCheck, IRealmUtils realmUtils){
        return new AuthPresenterImpl(application, interactor, validator, networkCheck, realmUtils);
    }

    @Provides
    @AppScope
    IPresenterContract.ISplashPresenter providesSplashPresenter(Application application, IRealmUtils realmUtils) {
        return new SplashPresenterImpl(application, realmUtils);
    }

    @Provides
    @AppScope
    IPresenterContract.IMainPresenter providesMainPresenter(Application application, IBaseInteractor.IInteractor interactor
            , IValidator validator, INetworkCheck networkCheck, IRealmUtils realmUtils) {
        return new MainPresenterImpl(application, interactor, validator, networkCheck, realmUtils);
    }
}