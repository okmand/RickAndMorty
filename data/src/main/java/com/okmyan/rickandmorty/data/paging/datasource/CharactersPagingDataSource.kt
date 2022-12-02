package com.okmyan.rickandmorty.data.paging.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.okmyan.rickandmorty.data.dto.ResponseInfoDto
import com.okmyan.rickandmorty.data.mappers.InfoMapper
import com.okmyan.rickandmorty.data.parsers.UriParser
import com.okmyan.rickandmorty.data.service.CharactersApi
import com.okmyan.rickandmorty.domain.models.Character

class CharactersPagingDataSource constructor(
    private val service: CharactersApi
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: INITIAL_VALUE
        return try {
            val response = service.getCharacters(pageNumber)
            val pagedResponseDto = response.body() ?: ResponseInfoDto(null, null)
            val pagedResponse = InfoMapper.mapResponseInfo(pagedResponseDto)

            val data = pagedResponse.results
            val nextPageNumber: Int? = UriParser.parseNextOrPrevPageInUri(pagedResponse.info.next)
            val prevPageNumber: Int? = UriParser.parseNextOrPrevPageInUri(pagedResponse.info.prev)

            LoadResult.Page(
                data = data,
                prevKey = prevPageNumber,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int {
        val anchorPosition = state.anchorPosition ?: return INITIAL_VALUE
        val page = state.closestPageToPosition(anchorPosition) ?: return INITIAL_VALUE
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1) ?: INITIAL_VALUE
    }

    companion object {
        private const val INITIAL_VALUE = 1
    }
}
