package com.example.anhptt.architechmvp.main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.anhptt.architechmvp.data.source.repository.LoginDataRepository;
import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.login.pojo.User;

import java.util.List;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = MainActivityPresenter.class.getSimpleName();

    @NonNull
    private MainActivityContract.View mView;

    @Inject
    LoginDataRepository loginDataRepository;

    @Inject
    Activity activity;

    @Inject
    Context context;

    @Inject
    public MainActivityPresenter(MainActivityContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        if (context != null){
            Log.d(TAG, "context was dependency injection");
        }else{
            Log.d(TAG, "context not dependency injection");
        }
        if (activity != null){
            Log.d(TAG, "activity was dependency injection");
        }else{
            Log.d(TAG, "activity not dependency injection");
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void getUserList() {
        mView.showOpenLoading();
        loginDataRepository.getUserList(new LoginDataSource.UserDataListCallback() {
            @Override
            public void onUserDataListCallback(List<User> dataList) {
                mView.showUserList(dataList);
                mView.showCloseLoading();
            }

            @Override
            public void onUserDataListNotAvailable() {
                mView.showCloseLoading();
            }
        });
    }
}
