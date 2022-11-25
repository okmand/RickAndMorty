package com.okmyan.rickandmorty.di

import android.app.Application
import com.okmyan.rickandmorty.data.di.RepositoryModule
import com.okmyan.rickandmorty.domain.usecases.UsersUseCase
import com.okmyan.rickandmorty.usersscreen.di.UsersScreenDependencies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [
        AppModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent : UsersScreenDependencies {

    override val usersUseCase: UsersUseCase

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun infoForDataService(@InfoForDataServiceQualifier info: String): Builder

        fun build(): AppComponent
    }

}

@Scope
annotation class AppScope