package com.chyngyz.quwitestapp.login.api;

import com.chyngyz.quwitestapp.login.api.model.LoginRequest;
import com.chyngyz.quwitestapp.login.api.model.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("auth/login")
    Observable<LoginResponse> login(@Body LoginRequest body);
}
