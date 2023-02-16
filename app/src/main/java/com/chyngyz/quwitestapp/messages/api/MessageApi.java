package com.chyngyz.quwitestapp.messages.api;

import com.chyngyz.quwitestapp.messages.api.model.ChannelsResponse;
import com.chyngyz.quwitestapp.messages.api.model.MessagesResponse;
import com.chyngyz.quwitestapp.messages.api.model.UsersResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MessageApi {

    @GET("chat-channels")
    Observable<ChannelsResponse> getChants();

    @GET("users/foreign")
    Observable<UsersResponse> getUsers(@Query("ids") List<String> ids);
}
