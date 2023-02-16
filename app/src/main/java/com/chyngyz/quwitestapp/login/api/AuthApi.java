package com.chyngyz.quwitestapp.login.api;

import com.chyngyz.quwitestapp.login.api.model.LoginRequest;
import com.chyngyz.quwitestapp.login.api.model.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("auth/login")
    Single<LoginResponse> login(@Body LoginRequest body);

    @POST("auth/logout")
    Single<Object> logout();
}
