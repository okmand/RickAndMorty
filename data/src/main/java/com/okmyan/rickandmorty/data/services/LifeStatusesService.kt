package com.okmyan.rickandmorty.data.services

import com.okmyan.rickandmorty.domain.models.AliveStatus
import com.okmyan.rickandmorty.domain.models.DeadStatus
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.models.UnknownStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LifeStatusesService @Inject constructor() {

    fun getLifeStatuses(): Flow<List<LifeStatus>> {
        return flowOf(listOf(AliveStatus(), UnknownStatus(), DeadStatus()))
    }

}
