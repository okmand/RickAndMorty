package com.okmyan.gitusers

import android.app.Application
import com.okmyan.gitusers.di.AppComponent
import com.okmyan.gitusers.di.DaggerAppComponent
import com.okmyan.gitusers.usersscreen.di.UsersScreenDependenciesStore

class GitUsersApp : Application() {

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