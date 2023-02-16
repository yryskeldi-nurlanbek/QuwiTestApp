package com.chyngyz.quwitestapp.login.repository;

import com.chyngyz.quwitestapp.login.api.AuthApi;
import com.chyngyz.quwitestapp.login.api.model.LoginRequest;
import com.chyngyz.quwitestapp.login.api.model.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthRemoteRepository implements AuthRepository {

    private final AuthApi api;

    @Inject
    public AuthRemoteRepository(AuthApi api) {
        this.api = api;
    }

    @Override
    public Single<String> login(String email, String password) {
        return api.login(new LoginRequest(email, password))
                .map(LoginResponse::getToken);
    }

    @Override
    public Single<Object> logout() {
        return api.logout();
    }
}
