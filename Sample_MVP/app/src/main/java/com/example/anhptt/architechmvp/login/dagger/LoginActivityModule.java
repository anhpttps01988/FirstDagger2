package com.example.anhptt.architechmvp.login.dagger;


import android.app.Activity;

import com.example.anhptt.architechmvp.common.di.ActivityScoped;
import com.example.anhptt.architechmvp.data.source.repository.LoginDataRepository;
import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.login.LoginActivityContract;
import com.example.anhptt.architechmvp.login.LoginActivityPresenter;
import com.example.anhptt.architechmvp.login.view.LoginActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginActivityModule {

    @ActivityScoped
    @Binds
    abstract LoginActivityContract.View view(LoginActivity loginActivity);

    @ActivityScoped
    @Binds
    abstract LoginActivityContract.Presenter presenter(LoginActivityPresenter presenter);

    @ActivityScoped
    @Binds
    abstract Activity activity(LoginActivity loginActivity);

    @ActivityScoped
    @Binds
    abstract LoginDataSource loginDataRepository(LoginDataRepository loginDataRepository);

}
