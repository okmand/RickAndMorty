package com.okmyan.rickandmorty.data.mappers

import com.okmyan.rickandmorty.domain.models.AliveStatus
import com.okmyan.rickandmorty.domain.models.DeadStatus
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.models.UnknownStatus

object LifeStatusMapper {

    fun mapLifeStatus(status: String): LifeStatus {
        return when (status) {
            LifeStatus.STATUS_ALIVE -> AliveStatus()
            LifeStatus.STATUS_DEAD -> DeadStatus()
            else -> UnknownStatus()
        }
    }

}
