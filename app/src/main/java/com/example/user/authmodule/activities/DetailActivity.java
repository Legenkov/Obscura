package com.example.user.authmodule.activities;

/**
 * Created by User on 14.04.2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.user.authmodule.R;
import com.example.user.authmodule.common.IDetailListener;
import com.example.user.authmodule.fragments.DetailsFragment;


public class DetailActivity extends AppCompatActivity {

    private IDetailListener onDetailsListener = new IDetailListener() {
        @Override
        public void getInfo(String email, String password) {
            Toast.makeText(DetailActivity.this, "GetInfo\n email" + email +
                    "\n password " + password + "\n", Toast.LENGTH_LONG ).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_details_activity,
                DetailsFragment.newInstance(onDetailsListener)).commit();




    }

}