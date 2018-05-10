package com.example.user.authmodule.utils.validator;

/**
 * Created by User on 14.04.2018.
 */

public interface IValidator {
    boolean isPhoneValid(String phone);
    boolean isEmailValid(String email);
    boolean isPasswordValid(String password);
}
