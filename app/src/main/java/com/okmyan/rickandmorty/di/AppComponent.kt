package com.okmyan.rickandmorty.di

import android.app.Application
import com.okmyan.rickandmorty.charactersscreen.di.CharactersScreenDependencies
import com.okmyan.rickandmorty.data.di.DataModule
import com.okmyan.rickandmorty.data.di.NetworkModule
import com.okmyan.rickandmorty.data.di.RepositoryModule
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCase
import com.okmyan.rickandmorty.domain.usecases.LifeStatusesUseCase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [
        DataModule::class,
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent : CharactersScreenDependencies {

    override val charactersUseCase: CharactersUseCase

    override val lifeStatusesUseCase: LifeStatusesUseCase

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}

@Scope
annotation class AppScope
