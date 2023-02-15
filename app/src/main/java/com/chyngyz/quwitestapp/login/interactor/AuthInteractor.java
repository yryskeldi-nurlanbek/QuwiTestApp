package com.chyngyz.quwitestapp.login.interactor;

import com.chyngyz.quwitestapp.login.repository.AuthRepository;

import javax.inject.Inject;

public class AuthInteractor {

    private AuthRepository repository;

    @Inject
    public AuthInteractor(AuthRepository repository) {
        this.repository = repository;
    }

    public void login(String email, String password) {
        repository.login(email, password);
    }
}
