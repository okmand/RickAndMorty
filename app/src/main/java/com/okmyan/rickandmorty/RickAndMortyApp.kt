package com.okmyan.rickandmorty

import android.app.Application
import com.okmyan.rickandmorty.charactersscreen.di.CharactersScreenDependenciesStore
import com.okmyan.rickandmorty.di.AppComponent
import com.okmyan.rickandmorty.di.DaggerAppComponent

class RickAndMortyApp : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        CharactersScreenDependenciesStore.dependencies = appComponent
    }

}
