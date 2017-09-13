package com.example.anhptt.architechmvp.data.source.source;

import android.support.annotation.NonNull;

import com.example.anhptt.architechmvp.login.pojo.User;

import java.util.List;

public interface LoginDataSource{

    interface LoginCallback{
        void onLoginSuccess();
        void onLoginError();
    }

    interface UserDataListCallback{
        void onUserDataListCallback(List<User> dataList);
        void onUserDataListNotAvailable();
    }

    void getUserList(@NonNull UserDataListCallback userDataListCallback);

    void login(User user, LoginCallback loginCallback);



}
