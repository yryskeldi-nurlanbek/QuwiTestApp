package com.chyngyz.quwitestapp.login.ui;

import com.chyngyz.quwitestapp.common.mvp.BasePresenter;
import com.chyngyz.quwitestapp.login.interactor.AuthInteractor;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private final AuthInteractor interactor;

    @Inject
    public LoginPresenter(AuthInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void login(String email, String password) {
        try {
            getViewState().showLoading(true);
            interactor.login(email, password);
            getViewState().showLoginConfirmed();
        } catch (Throwable t) {
            getViewState().showErrorMessage(t);
        } finally {
            getViewState().showLoading(false);
        }
    }
}

