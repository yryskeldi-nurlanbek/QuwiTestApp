package com.chyngyz.quwitestapp.messages.api.model;

import com.google.gson.annotations.SerializedName;

public class MessagesResponse {

    @SerializedName("id_partner")
    private String partnerId;

    @SerializedName("message_last")
    private Message message;

    public String getPartnerId() {
        return partnerId;
    }

    public Message getMessage() {
        return message;
    }
}