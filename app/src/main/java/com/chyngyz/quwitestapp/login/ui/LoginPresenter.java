package com.chyngyz.quwitestapp.login.ui;

import com.chyngyz.quwitestapp.common.mvp.BasePresenter;
import com.chyngyz.quwitestapp.infrastructure.network.TokenProvider;
import com.chyngyz.quwitestapp.login.interactor.AuthInteractor;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private final AuthInteractor interactor;
    private final TokenProvider tokenProvider;

    @Inject
    public LoginPresenter(AuthInteractor interactor, TokenProvider tokenProvider) {
        this.interactor = interactor;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void login(String email, String password) {
        interactor.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        new SingleObserver<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                unsubscribeOnDestroy(d);
                            }

                            @Override
                            public void onSuccess(String token) {
                                tokenProvider.setToken(token);
                                view.showLoginConfirmed();
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.showErrorMessage(e);
                            }
                        }
                );
    }
}

