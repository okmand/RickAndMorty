package com.okmyan.rickandmorty.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(

    @SerialName("count")
    val charactersCount: Long?,

    @SerialName("pages")
    val pages: Long?,

    @SerialName("next")
    val nextPage: String?,

    @SerialName("prev")
    val prevPage: String?,

    )
