package com.example.anhptt.architechmvp.login;

import com.example.anhptt.architechmvp.common.mvp.BasePresenter;
import com.example.anhptt.architechmvp.common.mvp.BaseView;
import com.example.anhptt.architechmvp.login.pojo.User;

public interface LoginActivityContract {

    interface View extends BaseView<Presenter> {
        void showLoginSuccess();

        void showLoginError();

        void showOpenLoading();

        void showCloseLoading();

        void clearInput();
    }

    interface Presenter extends BasePresenter {
        void login(User user);
    }

}
