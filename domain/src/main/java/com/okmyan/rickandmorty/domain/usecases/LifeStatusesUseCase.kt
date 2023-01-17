package com.okmyan.rickandmorty.domain.usecases

import com.okmyan.rickandmorty.domain.models.LifeStatus.Companion.EMPTY_VALUE
import com.okmyan.rickandmorty.domain.repositories.LifeStatusesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LifeStatusesUseCase @Inject constructor(
    private val lifeStatusesRepository: LifeStatusesRepository,
) {

    suspend fun execute(): Flow<List<String>> = withContext(Dispatchers.IO) {
        return@withContext lifeStatusesRepository.getLifeStatuses()
            .map { list ->
                list.map { status ->
                    status.value
                }
            }
            .map { list ->
                listOf(EMPTY_VALUE) + list
            }
    }

}
