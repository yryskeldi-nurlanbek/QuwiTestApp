package com.chyngyz.quwitestapp.login.api;

import com.chyngyz.quwitestapp.login.api.model.LoginRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("auth/login")
    Observable<Object> login(@Body LoginRequest body);
}
