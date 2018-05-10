package com.example.user.authmodule.app;

/**
 * Created by User on 14.04.2018.
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;



@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}