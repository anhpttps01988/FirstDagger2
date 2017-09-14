package com.example.anhptt.architechmvp.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhptt.architechmvp.R;
import com.example.anhptt.architechmvp.common.di.ActivityScoped;
import com.example.anhptt.architechmvp.common.fragment.BaseFragment;
import com.example.anhptt.architechmvp.main.MainFragmentContract;

import javax.inject.Inject;

@ActivityScoped
public class MainFragment extends BaseFragment implements MainFragmentContract.View {

    @Inject
    MainFragmentContract.Presenter mPresenter;

    @Inject
    public MainFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void setPresenter(MainFragmentContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
