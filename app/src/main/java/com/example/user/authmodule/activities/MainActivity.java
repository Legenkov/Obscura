package com.example.user.authmodule.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.authmodule.R;
import com.example.user.authmodule.app.ObscuraApp;
import com.example.user.authmodule.auth_operation.activities.NavigationActivity;
import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.common.IMainListener;
import com.example.user.authmodule.fragments.MainFragment;
import com.example.user.authmodule.presenters.IPresenterContract;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IBaseView.IMainView {
    public static final String TAG = "MainOperation";

    private BottomNavigationView mNavigationView;
    private FragmentManager mFragmentManager;

    @Inject
    IPresenterContract.IMainPresenter mPresenter;

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnItemBottomItemSelectedListener = item -> {
        if (item.getItemId() == R.id.navigation_home) {
            Log.i(TAG, "Go home");
            return true;
        } else if (item.getItemId() == R.id.navigation_dashboard) {
            Log.i(TAG, "Go to the dashboard");
            return true;
        } else if (item.getItemId() == R.id.navigation_notifications) {
            Log.i(TAG, "Go to the notifications");
            return true;
        } else {
            return false;
        }
    };


    private IMainListener mMainListener = callback -> {
        mPresenter.doGetFeed(callback);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragmentManager = getSupportFragmentManager();

        mNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(mOnItemBottomItemSelectedListener);

        ObscuraApp.get(this).getAppComponent().inject(this);
        mPresenter.init(this);

        Fragment fragment = mFragmentManager.findFragmentById(R.id.content_main);

        if (fragment == null) {
            fragment = MainFragment.newInstance(mMainListener);

            mFragmentManager.beginTransaction()
                    .add(R.id.content_main, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_return:
                mPresenter.doLogout(null, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void doneLogout(String token, int type) {

    }

    @Override
    public void closeMain() {
        Intent i = new Intent(this, NavigationActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void showMessage(String s) {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }


}