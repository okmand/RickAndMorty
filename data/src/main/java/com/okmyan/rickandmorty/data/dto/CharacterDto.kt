package com.okmyan.rickandmorty.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(

    @SerialName("id")
    val id: Long?,

    @SerialName("name")
    val name: String?,

    @SerialName("status")
    val status: String?,

    @SerialName("species")
    val species: String?,

    @SerialName("type")
    val type: String?,

    @SerialName("gender")
    val gender: String?,

    @SerialName("origin")
    val origin: OriginDto?,

    @SerialName("location")
    val location: LocationDto?,

    @SerialName("image")
    val image: String?,

    @SerialName("episode")
    val episode: List<String?>?,

    @SerialName("url")
    val url: String?,

    @SerialName("created")
    val created: String?,

    )
