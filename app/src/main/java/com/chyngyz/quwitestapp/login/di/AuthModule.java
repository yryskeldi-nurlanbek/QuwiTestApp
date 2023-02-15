package com.chyngyz.quwitestapp.login.di;


import com.chyngyz.quwitestapp.login.api.AuthApi;
import com.chyngyz.quwitestapp.login.repository.AuthRepository;
import com.chyngyz.quwitestapp.login.repository.AuthRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;
import retrofit2.Retrofit;

@Module
@InstallIn(FragmentComponent.class)
public class AuthModule {

    @Provides
    @FragmentScoped
    AuthRepository provideRepository(Retrofit retrofit) {
        AuthApi api = retrofit.create(AuthApi.class);
        return new AuthRepositoryImpl(api);
    }
}
