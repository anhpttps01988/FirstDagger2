package com.example.anhptt.architechmvp.main;

import android.content.Context;

import javax.inject.Inject;

public class MainFragmentPresenter implements MainFragmentContract.Presenter{


    private MainFragmentContract.View mView;

    @Inject
    Context context;

    @Inject
    public MainFragmentPresenter(MainFragmentContract.View view){
        this.mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
