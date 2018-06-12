package com.example.user.authmodule.auth_operation.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.example.user.authmodule.R;
import com.example.user.authmodule.activities.BaseActivity;
import com.example.user.authmodule.app.ObscuraApp;
import com.example.user.authmodule.auth_operation.fragments.RecoverFragment;
import com.example.user.authmodule.auth_operation.fragments.SignInFragment;
import com.example.user.authmodule.auth_operation.fragments.SignUpFragment;
import com.example.user.authmodule.common.IAuthListener;
import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.presenters.IPresenterContract;

import javax.inject.Inject;

public class AuthActivity extends BaseActivity implements IBaseView.IAuthView {

    private static final int SCREEN_TYPE_SIGN_IN = 1;
    private static final int SCREEN_TYPE_SIGN_UP = 2;
    private static final int SCREEN_TYPE_RECOVER_ACCOUNT = 3;

    @Inject
    IPresenterContract.IAuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ObscuraApp.get(this).getAppComponent().inject(this);
//        presenter.init(this);
        onAuthListener.openFirstScreen(SCREEN_TYPE_SIGN_IN);
    }

    @Override
    public void showMessage(String s) {

    }

    @Override
    public void showError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }



    private IAuthListener onAuthListener = new IAuthListener() {

        @Override
        public void openSignIn() {
            AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignInFragment.newInstance(this), "Auth");
        }

        @Override
        public void openSignUp() {
            AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignUpFragment.newInstance(this), "Auth");
        }

        @Override
        public void openRecoverAccount() {
            AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, RecoverFragment.newInstance(this), "Auth");
        }

        @Override
        public void getSignIn(String email, String password) {
            presenter.doSignIn(email, password);
        }

        @Override
        public void getSignUp(String email, String phone, String password) {
            presenter.doSingUp(email, password);
        }

        @Override
        public void getRecoverAccount(String email) {
            presenter.doRecoverAccount(email);
        }

        @Override
        public void getSocialAuth(int type) {
//            presenter.doSocialAuth(AuthActivity.this, type);
        }

        @Override
        public void openFirstScreen(int type) {
            switch (type){
                case SCREEN_TYPE_SIGN_IN:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignInFragment.newInstance(this));
                    break;
                case SCREEN_TYPE_SIGN_UP:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignUpFragment.newInstance(this));
                    break;
                case SCREEN_TYPE_RECOVER_ACCOUNT:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, RecoverFragment.newInstance(this));
                    break;
            }
        }
    };

    @Override
    public void openMain(String token) {

    }
}



