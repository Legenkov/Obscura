package com.example.user.authmodule.app;

import android.app.Application;

import com.example.user.authmodule.realm.IRealmUtils;
import com.example.user.authmodule.realm.RealmUtilsImpl;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by dell e5540 on 3/13/2018.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @AppScope
    public Application provideApplication() {
        return application;
    }

//    @Provides
//    @AppScope
//    public IValidator provideValidator() {
//        return new ValidatorImpl();
//    }
//
//    @Provides
//    @AppScope
//    public INetworkCheck provideNetworkCheck() {
//        return new NetworkCheckImpl(application);
//    }

    @Provides
    @AppScope
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @AppScope
    IRealmUtils provideRealmService(final Realm realm) {
        return new RealmUtilsImpl(realm);
    }
}