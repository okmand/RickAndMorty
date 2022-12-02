package com.okmyan.rickandmorty.data.di

import com.okmyan.rickandmorty.data.paging.datasource.CharactersPagingDataSource
import com.okmyan.rickandmorty.data.service.CharactersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataModule {

    @Provides
    fun provideCharactersApi(retrofit: Retrofit): CharactersApi {
        return retrofit.create(CharactersApi::class.java)
    }

    @Provides
    fun providePagingDataSource(charactersApi: CharactersApi): CharactersPagingDataSource {
        return CharactersPagingDataSource(charactersApi)
    }

}
