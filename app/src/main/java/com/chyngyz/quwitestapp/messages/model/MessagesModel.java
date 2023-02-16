package com.chyngyz.quwitestapp.messages.model;

public class MessagesModel {

    private String partnerId;
    private String text;

    public MessagesModel(String partnerId, String text) {
        this.partnerId = partnerId;
        this.text = text;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getMessage() {
        return text;
    }
}
