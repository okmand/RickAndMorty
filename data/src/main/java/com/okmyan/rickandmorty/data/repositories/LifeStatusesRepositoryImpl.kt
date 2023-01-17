package com.okmyan.rickandmorty.data.repositories

import com.okmyan.rickandmorty.data.service.LifeStatusesService
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.repositories.LifeStatusesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LifeStatusesRepositoryImpl @Inject constructor(
    private val lifeStatusesService: LifeStatusesService
) : LifeStatusesRepository {

    override suspend fun getLifeStatuses(): Flow<List<LifeStatus>> = withContext(Dispatchers.IO) {
        return@withContext lifeStatusesService.getLifeStatuses()
    }

}
