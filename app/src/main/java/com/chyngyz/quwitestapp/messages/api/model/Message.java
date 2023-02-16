package com.chyngyz.quwitestapp.messages.api.model;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("text")
    private String text;

    public String getText() {
        return text;
    }
}
