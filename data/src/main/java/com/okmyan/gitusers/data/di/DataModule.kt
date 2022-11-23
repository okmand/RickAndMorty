package com.okmyan.gitusers.data.di

import com.okmyan.gitusers.data.repositories.DataRepositoryImpl
import com.okmyan.gitusers.domain.repositories.DataRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Suppress("FunctionName")
    @Binds
    fun bindDataRepositoryImpl_to_DataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepository

}