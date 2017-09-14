package com.example.anhptt.architechmvp.data.source.local;


import android.support.annotation.NonNull;

import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.login.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class UserLocalDataSource implements LoginDataSource {


    private List<User> mUserList = new ArrayList<>();

    @Inject
    public UserLocalDataSource(){

    }

    /*
          fake Data
       */
    private List<User> getUserList() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUser(String.format(Locale.getDefault(), "a - %d", i));
            mUserList.add(user);
        }
        return mUserList;
    }

    @Override
    public void getUserList(@NonNull UserDataListCallback userDataListCallback) {
        if (getUserList() != null && getUserList().size() > 0){
            userDataListCallback.onUserDataListCallback(getUserList());
        }else{
            userDataListCallback.onUserDataListNotAvailable();
        }
    }

    @Override
    public void login(User user, LoginCallback loginCallback) {

    }
}
