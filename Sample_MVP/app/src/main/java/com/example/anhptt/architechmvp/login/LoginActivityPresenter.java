package com.example.anhptt.architechmvp.login;

import android.app.Activity;
import android.util.Log;

import javax.inject.Inject;

public class LoginActivityPresenter implements LoginActivityContract.Presenter{
    private static final String TAG = LoginActivityPresenter.class.getSimpleName();

    private LoginActivityContract.View mView;

    @Inject
    Activity activity;

    @Inject
    public LoginActivityPresenter(LoginActivityContract.View view){
        this.mView = view;
    }

    @Override
    public void start() {
        if (activity != null){
            Log.d(TAG, "activity was dependency injection");
        }else{
            Log.d(TAG, "activity not dependency injection");
        }
    }

    @Override
    public void stop() {

    }
}
