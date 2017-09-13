package com.example.anhptt.architechmvp.common.di;


import com.example.anhptt.architechmvp.login.dagger.LoginActivityModule;
import com.example.anhptt.architechmvp.login.view.LoginActivity;
import com.example.anhptt.architechmvp.main.dagger.MainActivityModule;
import com.example.anhptt.architechmvp.main.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivity();
}
