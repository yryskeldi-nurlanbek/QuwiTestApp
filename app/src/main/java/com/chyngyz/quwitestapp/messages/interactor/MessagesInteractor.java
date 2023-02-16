package com.chyngyz.quwitestapp.messages.interactor;

import com.chyngyz.quwitestapp.messages.model.Message;
import com.chyngyz.quwitestapp.messages.repository.MessagesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class MessagesInteractor {

    private MessagesRepository repository;

    @Inject
    public MessagesInteractor(MessagesRepository repository) {
        this.repository = repository;
    }

    public Single<List<Message>> getChats() {
        return repository.getChats();
    }
}
