package com.okmyan.rickandmorty.domain.models

sealed class LifeStatus(val value: String) {

    companion object {
        fun getStatus(status: String): LifeStatus {
            return when (status) {
                STATUS_ALIVE -> AliveStatus()
                STATUS_DEAD -> DeadStatus()
                else -> UnknownStatus()
            }
        }

        const val STATUS_ALIVE = "Alive"
        const val STATUS_UNKNOWN = "Unknown"
        const val STATUS_DEAD = "Dead"
    }

}

class AliveStatus : LifeStatus(STATUS_ALIVE)
class UnknownStatus : LifeStatus(STATUS_UNKNOWN)
class DeadStatus : LifeStatus(STATUS_DEAD)
