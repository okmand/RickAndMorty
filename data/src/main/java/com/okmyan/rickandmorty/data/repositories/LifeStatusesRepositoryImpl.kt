package com.okmyan.rickandmorty.data.repositories

import com.okmyan.rickandmorty.data.service.LifeStatusesService
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.repositories.LifeStatusesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LifeStatusesRepositoryImpl @Inject constructor(
    private val lifeStatusesService: LifeStatusesService
) : LifeStatusesRepository {

    override suspend fun getLifeStatuses(): Flow<List<LifeStatus>> {
        return lifeStatusesService.getLifeStatuses()
    }

}
