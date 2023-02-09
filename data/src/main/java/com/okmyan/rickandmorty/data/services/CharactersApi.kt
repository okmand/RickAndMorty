package com.okmyan.rickandmorty.data.services

import com.okmyan.rickandmorty.data.constants.HttpAttributes.Companion.FIELD_PAGE
import com.okmyan.rickandmorty.data.constants.HttpAttributes.Companion.FIELD_STATUS
import com.okmyan.rickandmorty.data.dto.ResponseInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET(GET_REQUEST_CHARACTER)
    suspend fun getCharacters(
        @Query(FIELD_PAGE) page: Int,
        @Query(FIELD_STATUS) status: String? = null,
    ): Response<ResponseInfoDto>


    companion object {
        private const val GET_REQUEST_CHARACTER = "character"
    }

}
