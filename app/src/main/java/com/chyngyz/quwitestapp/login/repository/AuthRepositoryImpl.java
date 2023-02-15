package com.chyngyz.quwitestapp.login.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import com.chyngyz.quwitestapp.login.api.AuthApi;
import com.chyngyz.quwitestapp.login.api.model.LoginRequest;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AuthRepositoryImpl implements AuthRepository{

    private final AuthApi api;

    public AuthRepositoryImpl(AuthApi api) {
        this.api = api;
    }

    @SuppressLint("CheckResult")
    @Override
    public void login(String email, String password) {
        Observable<Object> observable = api.login(new LoginRequest(email, password));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);

    }

    private void handleResults(Object o) {
        Log.i("________", o.toString());
    }

    private void handleError(Throwable t) {
        Log.i("________", t.getMessage());
    }
}
