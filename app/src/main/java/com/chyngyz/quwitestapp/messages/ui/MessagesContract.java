package com.chyngyz.quwitestapp.messages.ui;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpView;

public interface MessagesContract {

    interface View extends MvpView {
        void showLoading(Boolean isLoading);
        void showChats(Object o);
        void showErrorMessage(@Nullable Throwable throwable);

    }

    interface Presenter {
        void loadChats();
    }
}
