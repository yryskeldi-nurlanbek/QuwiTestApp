package com.chyngyz.quwitestapp.messages.ui;

import androidx.annotation.Nullable;

import com.chyngyz.quwitestapp.common.mvp.MvpPresenter;
import com.chyngyz.quwitestapp.common.mvp.MvpView;
import com.chyngyz.quwitestapp.messages.model.Message;

import java.util.List;

public interface MessagesContract {

    interface View extends MvpView {
        void showLoading(Boolean isLoading);
        void showChats(List<Message> items);
        void showLogoutConfirmed();
        void showErrorMessage(@Nullable Throwable throwable);

    }

    interface Presenter extends MvpPresenter<View> {
        void loadChats();
        void logout();
    }
}
