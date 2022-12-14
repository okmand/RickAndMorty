package com.okmyan.rickandmorty.di

import com.okmyan.rickandmorty.data.DataService
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier


@Module
class AppModule {

    @AppScope
    @Provides
    fun provideDataService(@InfoForDataServiceQualifier info: String) = DataService(info)

}

@Qualifier
annotation class InfoForDataServiceQualifier