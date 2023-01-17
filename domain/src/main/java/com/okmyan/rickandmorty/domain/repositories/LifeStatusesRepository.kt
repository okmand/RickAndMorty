package com.okmyan.rickandmorty.domain.repositories

import com.okmyan.rickandmorty.domain.models.LifeStatus
import kotlinx.coroutines.flow.Flow

interface LifeStatusesRepository {

    suspend fun getLifeStatuses(): Flow<List<LifeStatus>>

}
