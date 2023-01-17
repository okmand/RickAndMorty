package com.okmyan.rickandmorty.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(

    @SerialName("count")
    val count: Long?,

    @SerialName("pages")
    val pages: Long?,

    @SerialName("next")
    val next: String?,

    @SerialName("prev")
    val prev: String?,

    )
