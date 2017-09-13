package com.example.anhptt.architechmvp.login.view;

import android.os.Bundle;

import com.example.anhptt.architechmvp.R;
import com.example.anhptt.architechmvp.common.activity.BaseActivity;
import com.example.anhptt.architechmvp.login.LoginActivityContract;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginActivityContract.View {

    @Inject
    LoginActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void setPresenter(LoginActivityContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
