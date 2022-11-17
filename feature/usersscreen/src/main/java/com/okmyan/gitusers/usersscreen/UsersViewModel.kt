package com.okmyan.gitusers.usersscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.okmyan.gitusers.api.DataService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

internal class UsersViewModel(private val dataService: DataService) : ViewModel() {

    val data = flow {
        try {
            delay(3000L)
            emit(dataService.getData())
        } catch (e: Exception) {
            Log.d(TAG, "Error ", e)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, "Init value")


    class Factory @Inject constructor(
        private val dataService: Provider<DataService>
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == UsersViewModel::class.java)
            return UsersViewModel(dataService.get()) as T
        }

    }

    private companion object {
        private const val TAG = "UsersViewModel"
    }

}