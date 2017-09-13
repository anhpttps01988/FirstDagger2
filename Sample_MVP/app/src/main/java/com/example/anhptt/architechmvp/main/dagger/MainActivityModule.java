package com.example.anhptt.architechmvp.main.dagger;


import android.app.Activity;

import com.example.anhptt.architechmvp.common.di.ActivityScoped;
import com.example.anhptt.architechmvp.main.MainActivityContract;
import com.example.anhptt.architechmvp.main.MainActivityPresenter;
import com.example.anhptt.architechmvp.main.view.MainActivity;

import dagger.Binds;
import dagger.Module;

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

}
