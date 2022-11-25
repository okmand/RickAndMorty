package com.okmyan.rickandmorty.usersscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.okmyan.rickandmorty.domain.usecases.UsersUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

internal class UsersViewModel(
    private val usersUseCase: UsersUseCase,
) : ViewModel() {

    val data = flow {
        try {
            delay(3000L)
            emit(usersUseCase.getData())
        } catch (e: Exception) {
            Log.d(TAG, "Error ", e)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, "Init value")


    class Factory @Inject constructor(
        private val usersUseCase: Provider<UsersUseCase>,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == UsersViewModel::class.java)
            return UsersViewModel(usersUseCase.get()) as T
        }

    }

    private companion object {
        private const val TAG = "UsersViewModel"
    }

}