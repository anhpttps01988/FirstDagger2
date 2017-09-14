package com.example.anhptt.architechmvp.main.dagger;


import android.app.Activity;

import com.example.anhptt.architechmvp.common.di.ActivityScoped;
import com.example.anhptt.architechmvp.common.di.FragmentScoped;
import com.example.anhptt.architechmvp.data.source.repository.LoginDataRepository;
import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;
import com.example.anhptt.architechmvp.main.MainActivityContract;
import com.example.anhptt.architechmvp.main.MainActivityPresenter;
import com.example.anhptt.architechmvp.main.view.MainActivity;
import com.example.anhptt.architechmvp.main.view.MainFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ActivityScoped
    @Binds
    abstract MainActivityContract.View view(MainActivity mainActivity);

    @ActivityScoped
    @Binds
    abstract MainActivityContract.Presenter presenter(MainActivityPresenter presenter);

    @ActivityScoped
    @Binds
    abstract Activity activity(MainActivity mainActivity);

    @ActivityScoped
    @Binds
    abstract LoginDataSource loginDataSource(LoginDataRepository loginDataRepository);
}
