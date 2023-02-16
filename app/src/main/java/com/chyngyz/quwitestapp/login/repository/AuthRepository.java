package com.chyngyz.quwitestapp.login.repository;


import io.reactivex.Single;

public interface AuthRepository {

    Single<String> login(String email, String password);
    Single<Object> logout();
}
