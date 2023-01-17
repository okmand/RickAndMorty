package com.okmyan.rickandmorty.domain.models

data class Location(
    val name: String,
    val url: String,
) {
    companion object {
        fun defaultLocation() = Location("", "")
    }
}
