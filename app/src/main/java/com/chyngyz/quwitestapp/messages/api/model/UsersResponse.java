package com.chyngyz.quwitestapp.messages.api.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UsersResponse {

    @SerializedName("name")
    private String name;

    @SerializedName("avatar_url")
    @Nullable
    private String avatarUrl;
}
