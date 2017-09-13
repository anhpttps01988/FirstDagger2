package com.example.anhptt.architechmvp.data.source.repository;

import android.support.annotation.NonNull;

import com.example.anhptt.architechmvp.common.di.Local;
import com.example.anhptt.architechmvp.common.di.Remote;
import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.login.pojo.User;

import java.util.List;

import javax.inject.Inject;

public class LoginDataRepository implements LoginDataSource {

    private LoginDataSource mLocalDataSource;
    private LoginDataSource mRemoteDataSource;

    @Inject
    public LoginDataRepository(@Remote LoginDataSource remoteDataSource, @Local LoginDataSource localDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getUserList(@NonNull UserDataListCallback userDataListCallback) {
        mLocalDataSource.getUserList(new UserDataListCallback() {
            @Override
            public void onUserDataListCallback(List<User> dataList) {
                userDataListCallback.onUserDataListCallback(dataList);
            }

            @Override
            public void onUserDataListNotAvailable() {
                userDataListCallback.onUserDataListNotAvailable();
            }
        });
    }

    @Override
    public void login(User user, LoginCallback loginCallback) {
        mRemoteDataSource.login(user, new LoginCallback() {
            @Override
            public void onLoginSuccess() {
                loginCallback.onLoginSuccess();
            }

            @Override
            public void onLoginError() {
                loginCallback.onLoginError();
            }
        });
    }


}
