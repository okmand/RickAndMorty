package com.okmyan.rickandmorty.data.di

import com.okmyan.rickandmorty.core.scopes.AppScope
import com.okmyan.rickandmorty.data.mappers.InfoMapper
import com.okmyan.rickandmorty.data.mappers.LifeStatusMapper
import com.okmyan.rickandmorty.data.services.CharactersApi
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

    @AppScope
    @Provides
    fun provideInfoMapper(): InfoMapper {
        return InfoMapper(LifeStatusMapper)
    }

}
