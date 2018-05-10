package com.example.user.authmodule.app;

/**
 * Created by User on 14.04.2018.
 */

import com.example.user.authmodule.activities.MainActivity;
import com.example.user.authmodule.auth_operation.activities.AuthActivity;
import com.example.user.authmodule.auth_operation.activities.SplashActivity;

import dagger.Component;

@AppScope
@Component(
        modules = {
                AppModule.class,
                UtilsModule.class,
                ApiModule.class,
                PresenterModule.class
        }
)

public interface AppComponent {
    void inject(SplashActivity activity);
    void inject(AuthActivity activity);
    void inject(MainActivity activity);
}