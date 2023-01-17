package com.okmyan.rickandmorty.charactersscreen

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCase
import com.okmyan.rickandmorty.domain.usecases.LifeStatusesUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Provider

internal class CharactersViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val lifeStatusesUseCase: LifeStatusesUseCase,
) : ViewModel() {

    private val handlerException = CoroutineExceptionHandler { _, throwable ->
        Log.e(
            TAG_IN_CoroutineExceptionHandler,
            "Exception handled: ${throwable.message} \n${throwable.stackTraceToString()}"
        )
    }
    private val vmScope =
        CoroutineScope(Dispatchers.Main.immediate + SupervisorJob() + handlerException)

    private var _charactersFlow: Flow<PagingData<Character>> = flowOf()
    val charactersFlow: Flow<PagingData<Character>>
        get() = _charactersFlow

    private var _lifeStatusesFlow: Flow<List<String>> = flowOf()
    val lifeStatusesFlow: Flow<List<String>>
        get() = _lifeStatusesFlow

    private val _currentLifeStatusFlow: MutableStateFlow<String> = MutableStateFlow("")
    val currentLifeStatusFlow: StateFlow<String>
        get() = _currentLifeStatusFlow

    init {
        getCharacters()
        getLifeStatuses()
    }

    fun setCurrentLifeStatus(lifeStatus: String = "") {
        _currentLifeStatusFlow.value = lifeStatus
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getCharacters() {
        vmScope.launch {
            _charactersFlow = _currentLifeStatusFlow
                .flatMapLatest { status ->
                    charactersUseCase.getCharacters(status)
                }
                .flowOn(Dispatchers.IO)
                .cachedIn(vmScope)
        }
    }

    private fun getLifeStatuses() {
        vmScope.launch(Dispatchers.IO) {
            _lifeStatusesFlow = lifeStatusesUseCase.execute()
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
        private const val TAG_IN_CoroutineExceptionHandler = "CoroutineException"
    }

}
