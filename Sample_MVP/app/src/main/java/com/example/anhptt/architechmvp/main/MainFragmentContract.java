package com.example.anhptt.architechmvp.main;

import com.example.anhptt.architechmvp.common.mvp.BasePresenter;
import com.example.anhptt.architechmvp.common.mvp.BaseView;

public interface MainFragmentContract {

    interface View extends BaseView<Presenter>{

    }

    interface Presenter extends BasePresenter{

    }

}
