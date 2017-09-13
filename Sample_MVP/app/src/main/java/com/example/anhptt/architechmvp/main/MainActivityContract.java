package com.example.anhptt.architechmvp.main;

import com.example.anhptt.architechmvp.common.mvp.BasePresenter;
import com.example.anhptt.architechmvp.common.mvp.BaseView;
import com.example.anhptt.architechmvp.login.pojo.User;

import java.util.List;

public interface MainActivityContract {

    interface View extends BaseView<Presenter>{
        void showUserList(List<User> userList);
        void showUserListError();
        void showOpenLoading();
        void showCloseLoading();
    }

    interface Presenter extends BasePresenter{
        void getUserList();
    }

}
