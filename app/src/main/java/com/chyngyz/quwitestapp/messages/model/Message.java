package com.chyngyz.quwitestapp.messages.model;

public class Message {

    private String partnerId;
    private String lastMessage = "";
    private User user;

    public Message(String partnerId, String lastMessage) {
        this.partnerId = partnerId;
        this.lastMessage = lastMessage;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
