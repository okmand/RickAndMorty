package com.okmyan.rickandmorty.domain.models

sealed class LifeStatus(val value: String) {

    companion object {

        const val STATUS_ALIVE = "Alive"
        const val STATUS_UNKNOWN = "Unknown"
        const val STATUS_DEAD = "Dead"
        const val EMPTY_VALUE = "-"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LifeStatus

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}

class AliveStatus : LifeStatus(STATUS_ALIVE)
class UnknownStatus : LifeStatus(STATUS_UNKNOWN)
class DeadStatus : LifeStatus(STATUS_DEAD)
