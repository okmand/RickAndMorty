package com.okmyan.rickandmorty.domain.usecases

import androidx.paging.PagingData
import com.google.common.base.Optional
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.repositories.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Provider

class CharactersUseCase @Inject constructor(
    private val charactersRepository: Provider<CharactersRepository>,
) {

    suspend fun getCharacters(
        lifeStatus: String
    ): Flow<PagingData<Character>> = withContext(Dispatchers.IO) {

        val optionalLifeStatus = if (checkRequiredConditionsForLifeStatus(lifeStatus)) {
            Optional.fromNullable(lifeStatus)
        } else {
            Optional.absent()
        }
        return@withContext charactersRepository.get().getCharacters(optionalLifeStatus)
    }

    private fun checkRequiredConditionsForLifeStatus(lifeStatus: String): Boolean {
        return lifeStatus != "" && lifeStatus != LifeStatus.EMPTY_VALUE
    }

}
