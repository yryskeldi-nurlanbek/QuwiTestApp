package com.chyngyz.quwitestapp.login.ui;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpView;

interface LoginContract {

    interface View extends MvpView {
        void showLoading(Boolean isLoading);
        void showLoginConfirmed();
        void showErrorMessage(@Nullable Throwable throwable);
    }

    interface Presenter {
        void login(String email, String password);
    }
}
