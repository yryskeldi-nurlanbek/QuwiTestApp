package com.chyngyz.quwitestapp.messages.repository;

import com.chyngyz.quwitestapp.messages.api.model.ChannelsResponse;
import com.chyngyz.quwitestapp.messages.api.model.MessagesResponse;
import com.chyngyz.quwitestapp.messages.api.model.UsersResponse;
import com.chyngyz.quwitestapp.messages.model.MessagesModel;

import java.util.List;

import io.reactivex.Observable;

public interface MessagesRepository {

    Observable<ChannelsResponse> getChats();
    Observable<UsersResponse> getUsers(List<String> ids);
}
