package com.okmyan.rickandmorty.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseInfoDto(

    @SerialName("info")
    val info: InfoDto?,

    @SerialName("results")
    val results: List<CharacterDto?>?,

    )
