package com.okmyan.gitusers.di

import android.app.Application
import com.okmyan.gitusers.api.DataService
import com.okmyan.gitusers.usersscreen.di.UsersScreenDependencies
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent : UsersScreenDependencies {

    override val dataService: DataService

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun infoForDataService(@InfoForDataServiceQualifier info: String): Builder

        fun build(): AppComponent
    }

}

@Module
class AppModule {

    @AppScope
    @Provides
    fun provideDataService(@InfoForDataServiceQualifier info: String) = DataService(info)

}

@Qualifier
annotation class InfoForDataServiceQualifier

@Scope
annotation class AppScope