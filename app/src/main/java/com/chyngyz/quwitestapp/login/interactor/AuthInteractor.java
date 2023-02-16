package com.chyngyz.quwitestapp.login.interactor;

import com.chyngyz.quwitestapp.login.repository.AuthRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthInteractor {

    private AuthRepository repository;

    @Inject
    public AuthInteractor(AuthRepository repository) {
        this.repository = repository;
    }

    public Single<String> login(String email, String password) {
       return repository.login(email, password);
    }

    public Single<Object> logout() {
        return repository.logout();
    }
}
