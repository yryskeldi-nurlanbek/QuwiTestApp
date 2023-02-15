package com.chyngyz.quwitestapp.login.ui;

import com.chyngyz.quwitestapp.common.mvp.MvpPresenter;
import com.chyngyz.quwitestapp.common.mvp.MvpView;

interface LoginContract {

    interface View extends MvpView {
        void showLoading(Boolean isLoading);
        void showLoginConfirmed();
    }

    interface Presenter extends MvpPresenter<View> {
        void login(String email, String password);
    }
}
