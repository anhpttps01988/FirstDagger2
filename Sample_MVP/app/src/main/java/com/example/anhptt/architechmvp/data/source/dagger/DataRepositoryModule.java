package com.example.anhptt.architechmvp.data.source.dagger;


import com.example.anhptt.architechmvp.common.di.Local;
import com.example.anhptt.architechmvp.common.di.Remote;
import com.example.anhptt.architechmvp.data.source.local.UserLocalDataSource;
import com.example.anhptt.architechmvp.data.source.remote.LoginRemoteDataSource;
import com.example.anhptt.architechmvp.data.source.source.LoginDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataRepositoryModule {

    @Singleton
    @Binds
    @Remote
    abstract LoginDataSource provideLoginRemoteDataSource(LoginRemoteDataSource loginRemoteDataSource);

    @Singleton
    @Binds
    @Local
    abstract LoginDataSource provideLoginLocalDataSource(UserLocalDataSource userLocalDataSource);

}
