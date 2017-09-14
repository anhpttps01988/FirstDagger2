package com.example.anhptt.architechmvp.data.source.remote;


import android.os.Handler;
import android.support.annotation.NonNull;

import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.login.pojo.User;

import javax.inject.Inject;

public class LoginRemoteDataSource implements LoginDataSource {
    /*
        fake data
     */
    private String remoteUser = "123";
    private String remotePass = "123";

    @Inject
    LoginRemoteDataSource(){

    }

    @Override
    public void getUserList(@NonNull UserDataListCallback userDataListCallback) {

    }

    @Override
    public void login(User user, LoginCallback loginCallback) {
        if (user != null) {
            new Handler().postDelayed(() -> {
                if (user.getUser().equals(remoteUser) && user.getPass().equals(remotePass)) {
                    loginCallback.onLoginSuccess();
                } else {
                    loginCallback.onLoginError();
                }
            },1000);
        }
    }

}
