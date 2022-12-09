package com.okmyan.rickandmorty.data.di

import com.okmyan.rickandmorty.data.service.CharactersApi
import com.okmyan.rickandmorty.data.service.LifeStatusesService
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
    fun provideLifeStatusesService() = LifeStatusesService()

}
