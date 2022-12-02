package com.okmyan.rickandmorty.domain.repositories

import androidx.paging.PagingData
import com.okmyan.rickandmorty.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    suspend fun getCharacters(): Flow<PagingData<Character>>

}
