package com.okmyan.rickandmorty.domain.usecases

import com.okmyan.rickandmorty.domain.models.*

object CharactersUseCaseTestEntity {

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

    private val CHARACTER_STATUS_0 = AliveStatus()
    private val CHARACTER_STATUS_1 = DeadStatus()
    private val CHARACTER_STATUS_2 = UnknownStatus()

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

    private val ORIGIN_0 = Origin(ORIGIN_LOCATION_NAME_0, ORIGIN_LOCATION_URL_0)
    private val ORIGIN_1 = Origin(ORIGIN_LOCATION_NAME_1, ORIGIN_LOCATION_URL_1)
    private val ORIGIN_2 = Origin(ORIGIN_LOCATION_NAME_2, ORIGIN_LOCATION_URL_2)

    private val LOCATION_0 = Location(ORIGIN_LOCATION_NAME_0, ORIGIN_LOCATION_URL_0)
    private val LOCATION_1 = Location(ORIGIN_LOCATION_NAME_1, ORIGIN_LOCATION_URL_1)
    private val LOCATION_2 = Location(ORIGIN_LOCATION_NAME_2, ORIGIN_LOCATION_URL_2)

    // Entities that are needed in tests
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
