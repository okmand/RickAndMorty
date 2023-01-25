package com.okmyan.rickandmorty.domain.models

data class Info(
    val charactersCount: Long,
    val pages: Long,
    val nextPage: String,
    val prevPage: String,
) {
    companion object {
        fun defaultInfo() = Info(0, 0, "", "")
    }
}
