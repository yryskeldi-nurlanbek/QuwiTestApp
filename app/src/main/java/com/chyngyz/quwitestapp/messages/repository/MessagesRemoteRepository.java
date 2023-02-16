package com.chyngyz.quwitestapp.messages.repository;

import com.chyngyz.quwitestapp.messages.api.MessageApi;
import com.chyngyz.quwitestapp.messages.api.model.ChannelsResponse;
import com.chyngyz.quwitestapp.messages.api.model.MessagesResponse;
import com.chyngyz.quwitestapp.messages.api.model.UserResponse;
import com.chyngyz.quwitestapp.messages.api.model.UsersResponse;
import com.chyngyz.quwitestapp.messages.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Single;

public class MessagesRemoteRepository implements MessagesRepository {

    private final MessageApi api;

    @Inject
    public MessagesRemoteRepository(MessageApi api) {
        this.api = api;
    }

    @Override
    public Single<List<Message>> getChats() {
        return api.getChannels().map(ChannelsResponse::getMessage)
                .flatMap(this::getFetchedChannelModel);
    }

    private Single<List<Message>> getFetchedChannelModel(List<MessagesResponse> values) {
        return getUserMap(values).map(userResponses -> {
            List<Message> items = new ArrayList<>(values.size());
            for (int i = 0; i < values.size(); ++i) {
                items.add(i, mapUser(values.get(i), userResponses));
            }
            return items;
        });
    }

    private Message mapUser(MessagesResponse response, Map<String, UserResponse> userResponses) {
        Message model = MessagesMapper.fromNetwork(response);
        model.setUser(MessagesMapper.fromNetwork(userResponses.get(response.getPartnerId())));
        return model;
    }

    private Single<HashMap<String, UserResponse>> getUserMap(List<MessagesResponse> values) {
        String ids = values.stream()
                .map(MessagesResponse::getPartnerId)
                .collect(Collectors.joining(",","",""));

        return api.getUsers(ids)
                .map(UsersResponse::getUsers)
                .map(userResponses -> {
                    HashMap<String, UserResponse> map = new HashMap<>();
                    for (UserResponse response : userResponses) {
                        map.put(response.getId(), response);
                    }
                    return map;
                });
    }
}
