package com.okmyan.rickandmorty.domain.models

data class Character(
    val id: Long,
    val name: String,
    val status: LifeStatus,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)
