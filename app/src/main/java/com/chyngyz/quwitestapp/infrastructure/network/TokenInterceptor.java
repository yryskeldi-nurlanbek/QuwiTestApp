package com.chyngyz.quwitestapp.infrastructure.network;

import androidx.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private final TokenProvider tokenProvider;

    @Inject
    public TokenInterceptor(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newRequest = request.newBuilder();

        newRequest.addHeader("Content-Type", "application/json");
        HttpUrl url = request.url();
        boolean isLogin = url.encodedPath().contains("auth/login");

        if (!isLogin) {
            newRequest.addHeader("Authorization", "Bearer " + tokenProvider.getToken());
        }

        return chain.proceed(newRequest.build());
    }
}