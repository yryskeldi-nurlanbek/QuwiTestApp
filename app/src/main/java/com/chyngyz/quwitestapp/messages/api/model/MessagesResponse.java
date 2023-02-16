package com.chyngyz.quwitestapp.messages.api.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class MessagesResponse {

    @SerializedName("id_partner")
    private String partnerId;

    @SerializedName("message_last")
    @Nullable
    private MessageResponse messageResponse;

    public String getPartnerId() {
        return partnerId;
    }

    @Nullable
    public MessageResponse getMessage() {
        return messageResponse;
    }
}