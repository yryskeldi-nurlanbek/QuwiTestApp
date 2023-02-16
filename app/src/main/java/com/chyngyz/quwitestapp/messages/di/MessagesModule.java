package com.chyngyz.quwitestapp.messages.di;

import com.chyngyz.quwitestapp.messages.api.MessageApi;
import com.chyngyz.quwitestapp.messages.repository.MessagesRemoteRepository;
import com.chyngyz.quwitestapp.messages.repository.MessagesRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;
import retrofit2.Retrofit;

@Module
@InstallIn(FragmentComponent.class)
public class MessagesModule {

    @Provides
    @FragmentScoped
    MessagesRepository provideRepository(Retrofit retrofit) {
        MessageApi api = retrofit.create(MessageApi.class);
        return new MessagesRemoteRepository(api);
    }
}
