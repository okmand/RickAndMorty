package com.okmyan.rickandmorty.usersscreen.di

import androidx.lifecycle.ViewModel
import com.okmyan.rickandmorty.core.Feature
import com.okmyan.rickandmorty.domain.usecases.UsersUseCase
import com.okmyan.rickandmorty.usersscreen.UsersScreenFragment
import dagger.Component
import kotlin.properties.Delegates.notNull

@Feature
@Component(dependencies = [UsersScreenDependencies::class])
internal interface UsersScreenComponent {

    fun inject(fragment: UsersScreenFragment)

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: UsersScreenDependencies): Builder

        fun build(): UsersScreenComponent

    }

}

interface UsersScreenDependencies {

    val usersUseCase: UsersUseCase

}

interface UsersScreenDependenciesProvider {

    val dependencies: UsersScreenDependencies

    companion object : UsersScreenDependenciesProvider by UsersScreenDependenciesStore

}

object UsersScreenDependenciesStore : UsersScreenDependenciesProvider {

    override var dependencies: UsersScreenDependencies by notNull()

}

internal class UsersScreenComponentViewModel : ViewModel() {

    val usersComponent =
        DaggerUsersScreenComponent.builder()
            .dependencies(UsersScreenDependenciesProvider.dependencies)
            .build()

}