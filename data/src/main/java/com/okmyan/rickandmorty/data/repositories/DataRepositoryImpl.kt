package com.okmyan.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.okmyan.rickandmorty.data.constants.Sizes.Companion.PAGE_SIZE
import com.okmyan.rickandmorty.data.paging.datasource.CharactersPagingDataSource
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.repositories.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val pagingDataSource: CharactersPagingDataSource,
) : DataRepository {

    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = true),
            pagingSourceFactory = { pagingDataSource },
        ).flow
    }

}
