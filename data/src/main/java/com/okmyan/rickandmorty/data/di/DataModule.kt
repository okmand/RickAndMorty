package com.okmyan.rickandmorty.data.di

import com.okmyan.rickandmorty.core.scopes.AppScope
import com.okmyan.rickandmorty.data.service.CharactersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataModule {

    @AppScope
    @Provides
    fun provideCharactersApi(retrofit: Retrofit): CharactersApi {
        return retrofit.create(CharactersApi::class.java)
    }

}
