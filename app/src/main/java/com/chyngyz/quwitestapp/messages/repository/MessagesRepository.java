package com.chyngyz.quwitestapp.messages.repository;

import com.chyngyz.quwitestapp.messages.model.Message;

import java.util.List;

import io.reactivex.Single;

public interface MessagesRepository {

    Single<List<Message>> getChats();
}
