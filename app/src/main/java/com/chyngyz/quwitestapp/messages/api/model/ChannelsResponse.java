package com.chyngyz.quwitestapp.messages.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelsResponse {

    @SerializedName("channels")
    private List<MessagesResponse> message;

    public List<MessagesResponse> getMessage() {
        return message;
    }
}
