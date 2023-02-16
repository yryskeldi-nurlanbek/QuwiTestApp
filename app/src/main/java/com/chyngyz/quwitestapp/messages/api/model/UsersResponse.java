package com.chyngyz.quwitestapp.messages.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {
    @SerializedName("users")
    private List<UserResponse> userResponses;

    public List<UserResponse> getUsers() {
        return userResponses;
    }
}
