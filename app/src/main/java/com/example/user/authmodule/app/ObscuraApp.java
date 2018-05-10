package com.example.user.authmodule.app;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by User on 14.04.2018.
 */

public class ObscuraApp extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }
    public static ObscuraApp get(Context context) {
        return (ObscuraApp) context.getApplicationContext();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilsModule(new UtilsModule())
                .apiModule(new ApiModule())
                .presenterModule(new PresenterModule())
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.initAppComponent();
        this.initRealmConfiguration();

    }

    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("obscura.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
