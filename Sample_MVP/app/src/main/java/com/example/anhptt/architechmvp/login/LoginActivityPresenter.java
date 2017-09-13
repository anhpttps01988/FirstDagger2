package com.example.anhptt.architechmvp.login;

import android.app.Activity;
import android.util.Log;

import com.example.anhptt.architechmvp.data.source.repository.LoginDataRepository;
import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.login.pojo.User;

import javax.inject.Inject;

public class LoginActivityPresenter implements LoginActivityContract.Presenter {
    private static final String TAG = LoginActivityPresenter.class.getSimpleName();

    private LoginActivityContract.View mView;

    @Inject
    LoginDataRepository loginDataRepository;

    @Inject
    Activity activity;

    @Inject
    LoginActivityPresenter(LoginActivityContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        if (activity != null) {
            Log.d(TAG, "activity was dependency injection");
        } else {
            Log.d(TAG, "activity not dependency injection");
        }
        if (loginDataRepository != null) {
            Log.d(TAG, "repository was dependency injection");
        } else {
            Log.d(TAG, "repository not dependency injection");
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void login(User user) {
        mView.showOpenLoading();
        loginDataRepository.login(user, new LoginDataSource.LoginCallback() {
            @Override
            public void onLoginSuccess() {
                mView.showCloseLoading();
                mView.showLoginSuccess();
                mView.clearInput();
            }

            @Override
            public void onLoginError() {
                mView.showCloseLoading();
                mView.showLoginError();
                mView.clearInput();
            }
        });
    }
}
