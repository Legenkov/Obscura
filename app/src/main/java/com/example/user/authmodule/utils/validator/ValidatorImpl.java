package com.example.user.authmodule.utils.validator;

/**
 * Created by User on 14.04.2018.
 */
import android.text.TextUtils;
import android.util.Patterns;
import 	java.util.regex.Pattern;

public class ValidatorImpl implements IValidator {
    @Override
    public boolean isPhoneValid(String phone) {
        if (!TextUtils.isEmpty(phone)) {
            return Patterns.PHONE.matcher(phone).matches();
        }
        return false;
    }

    @Override
    public boolean isEmailValid(String email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}