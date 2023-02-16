package com.chyngyz.quwitestapp.messages.api;

import com.chyngyz.quwitestapp.messages.api.model.ChannelsResponse;
import com.chyngyz.quwitestapp.messages.api.model.UsersResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MessageApi {

    @GET("chat-channels")
    Single<ChannelsResponse> getChannels();

    @GET("users/foreign")
    Single<UsersResponse> getUsers(@Query(value = "ids", encoded = true) String ids);
}
