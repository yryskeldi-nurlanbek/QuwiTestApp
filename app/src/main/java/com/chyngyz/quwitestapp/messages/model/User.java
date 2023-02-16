package com.chyngyz.quwitestapp.messages.model;

import androidx.annotation.Nullable;

public class User {

    private String name;
    @Nullable
    private String avatarUrl;

    public User(String name, @Nullable String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }
}
