package com.example.anhptt.architechmvp.main.dagger;

import android.app.Activity;

import com.example.anhptt.architechmvp.common.di.FragmentScoped;
import com.example.anhptt.architechmvp.main.MainFragmentContract;
import com.example.anhptt.architechmvp.main.MainFragmentPresenter;
import com.example.anhptt.architechmvp.main.view.MainActivity;
import com.example.anhptt.architechmvp.main.view.MainFragment;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainFragmentModule {


    @FragmentScoped
    @Binds
    abstract MainFragmentContract.View view(MainFragment mainFragment);

    @FragmentScoped
    @Binds
    abstract MainFragmentContract.Presenter presenter(MainFragmentPresenter presenter);

}
