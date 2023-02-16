package com.chyngyz.quwitestapp.login.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import com.chyngyz.quwitestapp.infrastructure.network.TokenProvider;
import com.chyngyz.quwitestapp.login.api.AuthApi;
import com.chyngyz.quwitestapp.login.api.model.LoginRequest;
import com.chyngyz.quwitestapp.login.api.model.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AuthRemoteRepository implements AuthRepository {

    private final AuthApi api;
    private final TokenProvider tokenProvider;

    @Inject
    public AuthRemoteRepository(AuthApi api, TokenProvider tokenProvider) {
        this.api = api;
        this.tokenProvider = tokenProvider;
    }

    @SuppressLint("CheckResult")
    @Override
    public void login(String email, String password) {
        Observable<LoginResponse> observable = api.login(new LoginRequest(email, password));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);

    }

    private void handleResults(LoginResponse response) {
        tokenProvider.setToken(response.getToken());
    }

    private void handleError(Throwable t) {
        Log.i("________", t.getMessage());
    }
}
