package com.okmyan.gitusers.di

import android.app.Application
import com.okmyan.gitusers.data.di.RepositoryModule
import com.okmyan.gitusers.domain.usecases.UsersUseCase
import com.okmyan.gitusers.usersscreen.di.UsersScreenDependencies
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