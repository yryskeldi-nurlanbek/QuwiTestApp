package com.chyngyz.quwitestapp.messages.interactor;

import com.chyngyz.quwitestapp.messages.repository.MessagesRepository;

import javax.inject.Inject;

public class MessagesInteractor {

    private MessagesRepository repository;

    @Inject
    public MessagesInteractor(MessagesRepository repository) {
        this.repository = repository;
    }

    public void getChats() {
        repository.getChats();
    }
}
