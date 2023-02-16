package com.chyngyz.quwitestapp.messages.repository;

import com.chyngyz.quwitestapp.messages.api.model.MessagesResponse;
import com.chyngyz.quwitestapp.messages.api.model.UserResponse;
import com.chyngyz.quwitestapp.messages.model.Message;
import com.chyngyz.quwitestapp.messages.model.User;

public class MessagesMapper {

    public static Message fromNetwork(MessagesResponse entity) {
        return new Message(
                entity.getPartnerId(),
                entity.getMessage() != null ? entity.getMessage().getText() : "" 
        );
    }

    public static User fromNetwork(UserResponse entity) {
        return new User(
                entity.getName(),
                entity.getAvatarUrl()
        );
    }
}
