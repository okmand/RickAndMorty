package com.okmyan.rickandmorty.domain.models

data class Origin(
    val name: String,
    val url: String,
) {
    companion object {
        fun defaultOrigin() = Origin("", "")
    }
}
