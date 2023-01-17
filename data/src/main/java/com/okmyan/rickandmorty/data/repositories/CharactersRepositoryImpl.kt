package com.okmyan.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.google.common.base.Optional
import com.okmyan.rickandmorty.data.constants.Sizes.Companion.PAGE_SIZE
import com.okmyan.rickandmorty.data.paging.datasource.CharactersPagingDataSource
import com.okmyan.rickandmorty.data.service.CharactersApi
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.repositories.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val service: CharactersApi,
) : CharactersRepository {

    override suspend fun getCharacters(
        lifeStatus: Optional<String>
    ): Flow<PagingData<Character>> = withContext(Dispatchers.IO) {
        return@withContext Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = true),
            pagingSourceFactory = {
                CharactersPagingDataSource(
                    service = service,
                    lifeStatus = lifeStatus,
                )
            },
        ).flow
    }

}
