package com.example.user.authmodule.auth_operation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;

import com.example.user.authmodule.R;


public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        AppCompatButton auth = (AppCompatButton) findViewById(R.id.btn_navigation_activity_sign_in);
        AppCompatButton main = (AppCompatButton) findViewById(R.id.btn_navigation_activity_skip);
        AppCompatButton signUp = (AppCompatButton) findViewById(R.id.btn_navigation_activity_sign_up);

        main.setOnClickListener(v -> {
            Intent intent = new Intent(NavigationActivity.this, AuthActivity.class);
            startActivity(intent);
        });

        auth.setOnClickListener(v -> {
            Intent auths = new Intent(NavigationActivity.this, AuthActivity.class);
            startActivity(auths);
        });
        signUp.setOnClickListener(v -> {
            Intent auth1 = new Intent(NavigationActivity.this, AuthActivity.class);
            startActivity(auth1);
        });
    }
}
