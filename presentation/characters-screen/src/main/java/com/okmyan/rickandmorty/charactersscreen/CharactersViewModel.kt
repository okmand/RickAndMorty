package com.okmyan.rickandmorty.charactersscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

internal class CharactersViewModel(
    private val charactersUseCase: CharactersUseCase,
) : ViewModel() {

    private lateinit var _charactersFlow: Flow<PagingData<Character>>
    val charactersFlow: Flow<PagingData<Character>>
        get() = _charactersFlow

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                _charactersFlow = charactersUseCase.getCharacters().cachedIn(viewModelScope)
            } catch (e: Exception) {
                Log.d(TAG, "Error ", e)
            }
        }
    }

    class Factory @Inject constructor(
        private val charactersUseCase: Provider<CharactersUseCase>,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == CharactersViewModel::class.java)
            return CharactersViewModel(charactersUseCase.get()) as T
        }

    }

    private companion object {
        private const val TAG = "CharactersViewModel"
    }

}
