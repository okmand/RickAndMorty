package com.okmyan.rickandmorty.data.di

import com.okmyan.rickandmorty.data.repositories.CharactersRepositoryImpl
import com.okmyan.rickandmorty.data.repositories.LifeStatusesRepositoryImpl
import com.okmyan.rickandmorty.domain.repositories.CharactersRepository
import com.okmyan.rickandmorty.domain.repositories.LifeStatusesRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Suppress("FunctionName")
    @Binds
    fun bindCharactersRepositoryImpl_to_CharactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository

    @Suppress("FunctionName")
    @Binds
    fun bindLifeStatusesRepositoryImpl_to_LifeStatusesRepository(lifeStatusesRepositoryImpl: LifeStatusesRepositoryImpl): LifeStatusesRepository

}
