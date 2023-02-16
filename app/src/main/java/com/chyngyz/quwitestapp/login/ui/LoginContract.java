package com.chyngyz.quwitestapp.login.ui;

import androidx.annotation.Nullable;

import com.chyngyz.quwitestapp.common.mvp.MvpPresenter;
import com.chyngyz.quwitestapp.common.mvp.MvpView;

interface LoginContract {

    interface View extends MvpView {
        void showLoginConfirmed();

        void showErrorMessage(@Nullable Throwable throwable);
    }

    interface Presenter extends MvpPresenter<View> {
        void login(String email, String password);
    }
}
