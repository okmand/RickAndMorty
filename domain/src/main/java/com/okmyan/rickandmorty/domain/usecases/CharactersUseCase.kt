package com.okmyan.rickandmorty.domain.usecases

import androidx.paging.PagingData
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.repositories.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {

    suspend fun getCharacters(): Flow<PagingData<Character>> {
        return dataRepository.getCharacters()
    }

}
