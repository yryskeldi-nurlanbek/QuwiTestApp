package com.chyngyz.quwitestapp.messages.api.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    private String name;

    @SerializedName("avatar_url")
    @Nullable
    private String avatarUrl;

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }
}
