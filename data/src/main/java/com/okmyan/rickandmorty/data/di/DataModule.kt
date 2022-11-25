package com.okmyan.rickandmorty.data.di

import com.okmyan.rickandmorty.data.repositories.DataRepositoryImpl
import com.okmyan.rickandmorty.domain.repositories.DataRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Suppress("FunctionName")
    @Binds
    fun bindDataRepositoryImpl_to_DataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepository

}