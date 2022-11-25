package com.okmyan.rickandmorty

import android.app.Application
import com.okmyan.rickandmorty.di.AppComponent
import com.okmyan.rickandmorty.di.DaggerAppComponent
import com.okmyan.rickandmorty.usersscreen.di.UsersScreenDependenciesStore

class RickAndMortyApp : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .infoForDataService(info)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        UsersScreenDependenciesStore.dependencies = appComponent
    }

    companion object {
        const val info = "some info for data service"
    }
}