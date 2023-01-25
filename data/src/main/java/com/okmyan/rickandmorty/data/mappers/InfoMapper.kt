package com.okmyan.rickandmorty.data.mappers

import com.okmyan.rickandmorty.data.dto.*
import com.okmyan.rickandmorty.domain.models.*

class InfoMapper(
    private val lifeStatusMapper: LifeStatusMapper,
) {

    fun mapResponseInfo(dto: ResponseInfoDto): ResponseInfo {
        val info = dto.info?.let { mapInfo(it) } ?: Info.defaultInfo()
        val results = (dto.results?.filterNotNull() ?: emptyList())
            .map { mapCharacter(it) }

        return ResponseInfo(
            info = info,
            results = results,
        )
    }


    private fun mapInfo(dto: InfoDto): Info {
        return dto.run {
            Info(
                charactersCount = charactersCount ?: 0,
                pages = pages ?: 0,
                nextPage = nextPage ?: "",
                prevPage = prevPage ?: "",
            )
        }
    }

    private fun mapCharacter(dto: CharacterDto): Character {
        val origin = dto.origin?.let { mapOrigin(it) } ?: Origin.defaultOrigin()
        val location = dto.location?.let { mapLocation(it) } ?: Location.defaultLocation()
        val episode = dto.episode?.filterNotNull() ?: emptyList()
        val status = lifeStatusMapper.mapLifeStatus(dto.status ?: "")

        return dto.run {
            Character(
                id = id ?: 0,
                name = name ?: "",
                status = status,
                species = species ?: "",
                type = type ?: "",
                gender = gender ?: "",
                origin = origin,
                location = location,
                image = image ?: "",
                episode = episode,
                url = url ?: "",
                created = created ?: "",
            )
        }
    }

    private fun mapLocation(dto: LocationDto): Location {
        return dto.run {
            Location(
                name = name ?: "",
                url = url ?: "",
            )
        }
    }

    private fun mapOrigin(dto: OriginDto): Origin {
        return dto.run {
            Origin(
                name = name ?: "",
                url = url ?: "",
            )
        }
    }
}
