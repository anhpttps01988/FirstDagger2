package com.example.anhptt.architechmvp.common.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
