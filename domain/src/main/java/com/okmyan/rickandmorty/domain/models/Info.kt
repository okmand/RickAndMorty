package com.okmyan.rickandmorty.domain.models

data class Info(
    val count: Long,
    val pages: Long,
    val next: String,
    val prev: String,
) {
    companion object {
        fun defaultInfo() = Info(0, 0, "", "")
    }
}
