package com.chyngyz.quwitestapp.messages.repository;

import com.chyngyz.quwitestapp.messages.api.model.MessagesResponse;
import com.chyngyz.quwitestapp.messages.model.MessagesModel;

public class MessagesMapper {

    public static MessagesModel fromNetwork(MessagesResponse entity) {
        return new MessagesModel(
                entity.getPartnerId(),
                entity.getMessage().getText()
        );
    }
}
