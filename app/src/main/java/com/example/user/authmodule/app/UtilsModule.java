package com.example.user.authmodule.app;

/**
 * Created by User on 14.04.2018.
 */

import android.app.Application;

import com.example.user.authmodule.utils.networkCheck.INetworkCheck;
import com.example.user.authmodule.utils.networkCheck.NetworkCheckImpl;
import com.example.user.authmodule.utils.validator.IValidator;
import com.example.user.authmodule.utils.validator.ValidatorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell e5540 on 3/24/2018.
 */
@Module
public class UtilsModule {

    @Provides
    @AppScope
    IValidator providesValidator (){
        return new ValidatorImpl();
    }

    @Provides
    @AppScope
    INetworkCheck providesNetworkCheck (Application application){
        return new NetworkCheckImpl(application);
    }
}
