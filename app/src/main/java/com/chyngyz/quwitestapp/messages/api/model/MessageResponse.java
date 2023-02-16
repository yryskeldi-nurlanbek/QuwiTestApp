package com.chyngyz.quwitestapp.messages.api.model;

import com.google.gson.annotations.SerializedName;

public class MessageResponse {

    @SerializedName("text")
    private String text = "";

    public String getText() {
        return text;
    }
}
