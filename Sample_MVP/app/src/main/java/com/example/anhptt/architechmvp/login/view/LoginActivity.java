package com.example.anhptt.architechmvp.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.anhptt.architechmvp.R;
import com.example.anhptt.architechmvp.common.activity.BaseActivity;
import com.example.anhptt.architechmvp.login.LoginActivityContract;
import com.example.anhptt.architechmvp.login.pojo.User;
import com.example.anhptt.architechmvp.main.view.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements LoginActivityContract.View {

    @Inject
    LoginActivityContract.Presenter mPresenter;


    @BindView(R.id.editUser)
    EditText editUser;
    @BindView(R.id.editPass)
    EditText editPass;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.progressBar)
    ProgressBar proBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        btnLogin.setOnClickListener(view -> {
            String user = editUser.getText().toString();
            String pass = editPass.getText().toString();
            User u = new User(user,pass);
            mPresenter.login(u);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Override
    public void setPresenter(LoginActivityContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOpenLoading() {
        proBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCloseLoading() {
        proBar.setVisibility(View.GONE);
    }

    @Override
    public void clearInput() {
        editUser.setText("");
        editPass.setText("");
        editUser.requestFocus();
    }
}
