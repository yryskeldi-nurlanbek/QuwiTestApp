package com.chyngyz.quwitestapp.messages.ui;

import com.chyngyz.quwitestapp.common.mvp.BasePresenter;
import com.chyngyz.quwitestapp.messages.interactor.MessagesInteractor;

import javax.inject.Inject;

public class MessagesPresenter extends BasePresenter<MessagesContract.View>
        implements MessagesContract.Presenter {

    private final MessagesInteractor interactor;

    @Inject
    public MessagesPresenter(MessagesInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void loadChats() {
        try {
            getViewState().showLoading(true);
            interactor.getChats();
        } catch (Throwable t) {
            getViewState().showErrorMessage(t);
        } finally {
            getViewState().showLoading(false);
        }
    }
}
