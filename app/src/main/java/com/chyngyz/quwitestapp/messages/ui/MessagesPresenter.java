package com.chyngyz.quwitestapp.messages.ui;

import com.chyngyz.quwitestapp.common.mvp.BasePresenter;
import com.chyngyz.quwitestapp.login.interactor.AuthInteractor;
import com.chyngyz.quwitestapp.messages.interactor.MessagesInteractor;
import com.chyngyz.quwitestapp.messages.model.Message;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MessagesPresenter extends BasePresenter<MessagesContract.View>
        implements MessagesContract.Presenter {

    private final MessagesInteractor messagesInteractor;
    private final AuthInteractor authInteractor;

    @Inject
    public MessagesPresenter(MessagesInteractor messagesInteractor, AuthInteractor authInteractor) {
        this.messagesInteractor = messagesInteractor;
        this.authInteractor = authInteractor;
    }

    @Override
    public void loadChats() {
        messagesInteractor.getChats()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        new SingleObserver<List<Message>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                unsubscribeOnDestroy(d);
                            }

                            @Override
                            public void onSuccess(List<Message> messages) {
                                view.showChats(messages);
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.showErrorMessage(e);
                                e.printStackTrace();
                            }
                        }
                );

    }

    @Override
    public void logout() {
        authInteractor.logout()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        new SingleObserver<Object>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                unsubscribeOnDestroy(d);
                            }

                            @Override
                            public void onSuccess(Object o) {
                                view.showLogoutConfirmed();
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.showErrorMessage(e);
                                e.printStackTrace();
                            }
                        }
                );
    }
}
