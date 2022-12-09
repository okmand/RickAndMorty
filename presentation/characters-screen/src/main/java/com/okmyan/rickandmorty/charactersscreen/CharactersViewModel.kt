package com.okmyan.rickandmorty.charactersscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCase
import com.okmyan.rickandmorty.domain.usecases.LifeStatusesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

internal class CharactersViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val lifeStatusesUseCase: LifeStatusesUseCase,
) : ViewModel() {

    private lateinit var _charactersFlow: Flow<PagingData<Character>>
    val charactersFlow: Flow<PagingData<Character>>
        get() = _charactersFlow

    private lateinit var _lifeStatusesFlow: Flow<List<String>>
    val lifeStatusesFlow: Flow<List<String>>
        get() = _lifeStatusesFlow

    private val currentLifeStatusFlow: MutableStateFlow<String> = MutableStateFlow("")

    init {
        getCharacters()
        getLifeStatuses()
    }

    fun setCurrentLifeStatus(lifeStatus: String) {
        currentLifeStatusFlow.value = lifeStatus
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getCharacters() {
        viewModelScope.launch {
            _charactersFlow = currentLifeStatusFlow
                .flatMapLatest { status -> charactersUseCase.getCharacters(status) }
                .cachedIn(viewModelScope)
                .catch { e ->
                    Log.d(TAG, "Error ", e)
                }
        }
    }

    private fun getLifeStatuses() {
        viewModelScope.launch {
            try {
                _lifeStatusesFlow = lifeStatusesUseCase.execute()
            } catch (e: Exception) {
                Log.d(TAG, "Error ", e)
            }
        }
    }

    class Factory @Inject constructor(
        private val charactersUseCase: Provider<CharactersUseCase>,
        private val lifeStatusesUseCase: Provider<LifeStatusesUseCase>,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == CharactersViewModel::class.java)
            return CharactersViewModel(charactersUseCase.get(), lifeStatusesUseCase.get()) as T
        }

    }

    private companion object {
        private const val TAG = "CharactersViewModel"
    }

}
