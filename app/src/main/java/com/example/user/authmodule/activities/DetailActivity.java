package com.example.user.authmodule.activities;

/**
 * Created by User on 14.04.2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.authmodule.R;
import com.example.user.authmodule.common.IDetailListener;
import com.example.user.authmodule.model.CommonRequest;


public class DetailActivity extends AppCompatActivity {
    private CommonRequest commonRequest;
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

        EditText name = (EditText) this.findViewById(R.id.editprofile_et_name);
        EditText surName = (EditText) this.findViewById(R.id.editprofile_et_surname);
        EditText middleName = (EditText) this.findViewById(R.id.editprofile_et_middlename);
        EditText  country = (EditText) this.findViewById(R.id.editprofile_et_country);
        EditText state = (EditText) this.findViewById(R.id.editprofile_et_state);
        EditText city = (EditText) this.findViewById(R.id.editprofile_et_city);
        AppCompatButton edit = (AppCompatButton) this.findViewById(R.id.editprofile_acbutton);



        name.setText("MakeText");
        surName.setText("MakeText");
        middleName.setText("MakeText");
        country.setText("MakeText");
        state.setText("MakeText");
        city.setText("MakeText");



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonRequest.setName(name.getText().toString());
                commonRequest.setLastname(surName.getText().toString());
                commonRequest.setMiddlename(middleName.getText().toString());
                commonRequest.setCountry_id(middleName.getText().toString());
                commonRequest.setState_id(state.getText().toString());
                commonRequest.setCity_id(city.getText().toString());

            }

        });
    }
}


