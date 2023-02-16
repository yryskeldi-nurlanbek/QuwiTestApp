package com.chyngyz.quwitestapp.infrastructure.network;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class TokenProvider {

    public static final String KEY_SESSION_TOKEN = "KEY_SESSION_TOKEN";
    public static final String KEY_SESSION_REFRESH_TOKEN = "KEY_SESSION_REFRESH_TOKEN";

    private SharedPreferences sharedPreferences;

    @Inject
    public TokenProvider(@ApplicationContext Context context) {
        String name = context.getPackageName() + ".prefs";
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public String getToken() {
        return sharedPreferences.getString(KEY_SESSION_TOKEN, "");
    }

    public void setToken(String token) {
        sharedPreferences.edit().putString(KEY_SESSION_TOKEN, token).commit();
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}