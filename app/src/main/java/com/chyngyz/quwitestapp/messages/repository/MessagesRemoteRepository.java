package com.chyngyz.quwitestapp.messages.repository;

import com.chyngyz.quwitestapp.messages.api.MessageApi;
import com.chyngyz.quwitestapp.messages.api.model.ChannelsResponse;
import com.chyngyz.quwitestapp.messages.api.model.UsersResponse;
import com.chyngyz.quwitestapp.messages.model.MessagesModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


public class MessagesRemoteRepository implements MessagesRepository {

    private final MessageApi api;

    @Inject
    public MessagesRemoteRepository(MessageApi api) {
        this.api = api;
    }

    @Override
    public Observable<ChannelsResponse> getChats() {
        return api.getChants().switchMap((Function<ChannelsResponse, ObservableSource<? extends List<MessagesModel>>>) channelsResponse ->
                Observable.just(channelsResponse.getMessage()).map(
                        MessagesMapper::fromNetwork
                ));
    }

    @Override
    public Observable<UsersResponse> getUsers(List<String> ids) {
        return null;
    }
}
