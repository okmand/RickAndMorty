package com.okmyan.rickandmorty.data.mappers

import com.okmyan.rickandmorty.data.dto.CharacterDto
import com.okmyan.rickandmorty.data.dto.InfoDto
import com.okmyan.rickandmorty.data.dto.LocationDto
import com.okmyan.rickandmorty.data.dto.OriginDto
import com.okmyan.rickandmorty.domain.models.*

object InfoMapperTestEntity {

    // InfoDto
    private const val INFO_CHARACTERS_COUNT_0 = 50L
    private const val INFO_CHARACTERS_COUNT_1 = 150L
    private const val INFO_CHARACTERS_COUNT_2 = 250L

    private const val INFO_PAGES_0 = 10L
    private const val INFO_PAGES_1 = 20L
    private const val INFO_PAGES_2 = 30L

    private const val INFO_NEXT_PAGE_0 = "https://rickandmortyapi.com/api/character?page=3"
    private const val INFO_NEXT_PAGE_1 = "https://rickandmortyapi.com/api/character?page=4"
    private const val INFO_NEXT_PAGE_2 = "https://rickandmortyapi.com/api/character?page=5"

    private const val INFO_PREV_PAGE_0 = "https://rickandmortyapi.com/api/character?page=1"
    private const val INFO_PREV_PAGE_1 = "https://rickandmortyapi.com/api/character?page=2"
    private const val INFO_PREV_PAGE_2 = "https://rickandmortyapi.com/api/character?page=3"

    // OriginDto and LocationDto
    private const val ORIGIN_LOCATION_NAME_0 = "Earth (C-137)"
    private const val ORIGIN_LOCATION_NAME_1 = "Citadel of Ricks"
    private const val ORIGIN_LOCATION_NAME_2 = "Anatomy Park"

    private const val ORIGIN_LOCATION_URL_0 = "https://rickandmortyapi.com/api/location/1"
    private const val ORIGIN_LOCATION_URL_1 = "https://rickandmortyapi.com/api/location/3"
    private const val ORIGIN_LOCATION_URL_2 = "https://rickandmortyapi.com/api/location/5"

    // CharacterDto
    private const val CHARACTER_ID_0 = 200L
    private const val CHARACTER_ID_1 = 201L
    private const val CHARACTER_ID_2 = 202L

    private const val CHARACTER_NAME_0 = "firstName secondName 0"
    private const val CHARACTER_NAME_1 = "firstName secondName 1"
    private const val CHARACTER_NAME_2 = "firstName secondName 2"

    const val CHARACTER_STATUS_IN_STRING_0 = LifeStatus.STATUS_ALIVE
    const val CHARACTER_STATUS_IN_STRING_1 = LifeStatus.STATUS_DEAD
    private const val CHARACTER_STATUS_IN_STRING_2 = LifeStatus.STATUS_UNKNOWN
    val CHARACTER_STATUS_0 = AliveStatus()
    val CHARACTER_STATUS_1 = DeadStatus()
    val CHARACTER_STATUS_2 = UnknownStatus()

    private const val CHARACTER_SPECIES_0 = "Humanoid"
    private const val CHARACTER_SPECIES_1 = "Alien"
    private const val CHARACTER_SPECIES_2 = "Human"

    private const val CHARACTER_TYPE_0 = "Parasite"
    private const val CHARACTER_TYPE_1 = "Genetic experiment"
    private const val CHARACTER_TYPE_2 = "Human with antennae"

    private const val CHARACTER_GENDER_0 = "Male"
    private const val CHARACTER_GENDER_1 = "Female"
    private const val CHARACTER_GENDER_2 = "unknown"

    private const val CHARACTER_IMAGE_0 = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    private const val CHARACTER_IMAGE_1 = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
    private const val CHARACTER_IMAGE_2 = "https://rickandmortyapi.com/api/character/avatar/3.jpeg"

    private const val EPISODE_0 = "https://rickandmortyapi.com/api/episode/1"
    private const val EPISODE_1 = "https://rickandmortyapi.com/api/episode/2"
    private const val EPISODE_2 = "https://rickandmortyapi.com/api/episode/3"

    private val CHARACTER_EPISODE_0 = listOf(EPISODE_0)
    private val CHARACTER_EPISODE_1 = listOf(EPISODE_0, EPISODE_1)
    private val CHARACTER_EPISODE_2 = listOf(EPISODE_1, EPISODE_2)

    private const val CHARACTER_URL_0 = "https://rickandmortyapi.com/api/character/1"
    private const val CHARACTER_URL_1 = "https://rickandmortyapi.com/api/character/2"
    private const val CHARACTER_URL_2 = "https://rickandmortyapi.com/api/character/3"

    private const val CHARACTER_CREATED_0 = "2020-10-20"
    private const val CHARACTER_CREATED_1 = "2021-10-20"
    private const val CHARACTER_CREATED_2 = "2022-10-20"

    private val ORIGIN_DTO_0 = OriginDto(ORIGIN_LOCATION_NAME_0, ORIGIN_LOCATION_URL_0)
    private val ORIGIN_DTO_1 = OriginDto(ORIGIN_LOCATION_NAME_1, ORIGIN_LOCATION_URL_1)
    private val ORIGIN_DTO_2 = OriginDto(ORIGIN_LOCATION_NAME_2, ORIGIN_LOCATION_URL_2)

    private val ORIGIN_0 = Origin(ORIGIN_LOCATION_NAME_0, ORIGIN_LOCATION_URL_0)
    private val ORIGIN_1 = Origin(ORIGIN_LOCATION_NAME_1, ORIGIN_LOCATION_URL_1)
    private val ORIGIN_2 = Origin(ORIGIN_LOCATION_NAME_2, ORIGIN_LOCATION_URL_2)

    private val LOCATION_DTO_0 = LocationDto(ORIGIN_LOCATION_NAME_0, ORIGIN_LOCATION_URL_0)
    private val LOCATION_DTO_1 = LocationDto(ORIGIN_LOCATION_NAME_1, ORIGIN_LOCATION_URL_1)
    private val LOCATION_DTO_2 = LocationDto(ORIGIN_LOCATION_NAME_2, ORIGIN_LOCATION_URL_2)

    private val LOCATION_0 = Location(ORIGIN_LOCATION_NAME_0, ORIGIN_LOCATION_URL_0)
    private val LOCATION_1 = Location(ORIGIN_LOCATION_NAME_1, ORIGIN_LOCATION_URL_1)
    private val LOCATION_2 = Location(ORIGIN_LOCATION_NAME_2, ORIGIN_LOCATION_URL_2)

    // Entities that are needed in tests
    val INFO_DTO_0 = InfoDto(
        charactersCount = INFO_CHARACTERS_COUNT_0,
        pages = INFO_PAGES_0,
        nextPage = INFO_NEXT_PAGE_0,
        prevPage = INFO_PREV_PAGE_0
    )
    val INFO_0 = Info(
        charactersCount = INFO_CHARACTERS_COUNT_0,
        pages = INFO_PAGES_0,
        nextPage = INFO_NEXT_PAGE_0,
        prevPage = INFO_PREV_PAGE_0
    )

    val INFO_DTO_1 = InfoDto(
        charactersCount = INFO_CHARACTERS_COUNT_1,
        pages = INFO_PAGES_1,
        nextPage = INFO_NEXT_PAGE_1,
        prevPage = INFO_PREV_PAGE_1
    )
    val INFO_1 = Info(
        charactersCount = INFO_CHARACTERS_COUNT_1,
        pages = INFO_PAGES_1,
        nextPage = INFO_NEXT_PAGE_1,
        prevPage = INFO_PREV_PAGE_1
    )

    val INFO_DTO_2 = InfoDto(
        charactersCount = INFO_CHARACTERS_COUNT_2,
        pages = INFO_PAGES_2,
        nextPage = INFO_NEXT_PAGE_2,
        prevPage = INFO_PREV_PAGE_2
    )
    val INFO_2 = Info(
        charactersCount = INFO_CHARACTERS_COUNT_2,
        pages = INFO_PAGES_2,
        nextPage = INFO_NEXT_PAGE_2,
        prevPage = INFO_PREV_PAGE_2
    )

    val CHARACTER_DTO_0 = CharacterDto(
        id = CHARACTER_ID_0,
        name = CHARACTER_NAME_0,
        status = CHARACTER_STATUS_IN_STRING_0,
        species = CHARACTER_SPECIES_0,
        type = CHARACTER_TYPE_0,
        gender = CHARACTER_GENDER_0,
        origin = ORIGIN_DTO_0,
        location = LOCATION_DTO_0,
        image = CHARACTER_IMAGE_0,
        episode = CHARACTER_EPISODE_0,
        url = CHARACTER_URL_0,
        created = CHARACTER_CREATED_0
    )
    val CHARACTER_0 = Character(
        id = CHARACTER_ID_0,
        name = CHARACTER_NAME_0,
        status = CHARACTER_STATUS_0,
        species = CHARACTER_SPECIES_0,
        type = CHARACTER_TYPE_0,
        gender = CHARACTER_GENDER_0,
        origin = ORIGIN_0,
        location = LOCATION_0,
        image = CHARACTER_IMAGE_0,
        episode = CHARACTER_EPISODE_0,
        url = CHARACTER_URL_0,
        created = CHARACTER_CREATED_0
    )

    val CHARACTER_DTO_1 = CharacterDto(
        id = CHARACTER_ID_1,
        name = CHARACTER_NAME_1,
        status = CHARACTER_STATUS_IN_STRING_1,
        species = CHARACTER_SPECIES_1,
        type = CHARACTER_TYPE_1,
        gender = CHARACTER_GENDER_1,
        origin = ORIGIN_DTO_1,
        location = LOCATION_DTO_1,
        image = CHARACTER_IMAGE_1,
        episode = CHARACTER_EPISODE_1,
        url = CHARACTER_URL_1,
        created = CHARACTER_CREATED_1
    )
    val CHARACTER_1 = Character(
        id = CHARACTER_ID_1,
        name = CHARACTER_NAME_1,
        status = CHARACTER_STATUS_1,
        species = CHARACTER_SPECIES_1,
        type = CHARACTER_TYPE_1,
        gender = CHARACTER_GENDER_1,
        origin = ORIGIN_1,
        location = LOCATION_1,
        image = CHARACTER_IMAGE_1,
        episode = CHARACTER_EPISODE_1,
        url = CHARACTER_URL_1,
        created = CHARACTER_CREATED_1
    )

    val CHARACTER_DTO_2 = CharacterDto(
        id = CHARACTER_ID_2,
        name = CHARACTER_NAME_2,
        status = CHARACTER_STATUS_IN_STRING_2,
        species = CHARACTER_SPECIES_2,
        type = CHARACTER_TYPE_2,
        gender = CHARACTER_GENDER_2,
        origin = ORIGIN_DTO_2,
        location = LOCATION_DTO_2,
        image = CHARACTER_IMAGE_2,
        episode = CHARACTER_EPISODE_2,
        url = CHARACTER_URL_2,
        created = CHARACTER_CREATED_2
    )
    val CHARACTER_2 = Character(
        id = CHARACTER_ID_2,
        name = CHARACTER_NAME_2,
        status = CHARACTER_STATUS_2,
        species = CHARACTER_SPECIES_2,
        type = CHARACTER_TYPE_2,
        gender = CHARACTER_GENDER_2,
        origin = ORIGIN_2,
        location = LOCATION_2,
        image = CHARACTER_IMAGE_2,
        episode = CHARACTER_EPISODE_2,
        url = CHARACTER_URL_2,
        created = CHARACTER_CREATED_2
    )
}
