package com.okmyan.rickandmorty.domain.repositories

import androidx.paging.PagingData
import com.google.common.base.Optional
import com.okmyan.rickandmorty.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getCharacters(lifeStatus: Optional<String>): Flow<PagingData<Character>>

}
