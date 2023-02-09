package com.okmyan.rickandmorty.data.paging.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.common.base.Optional
import com.okmyan.rickandmorty.data.dto.ResponseInfoDto
import com.okmyan.rickandmorty.data.mappers.InfoMapper
import com.okmyan.rickandmorty.data.parsers.UriParser
import com.okmyan.rickandmorty.data.services.CharactersApi
import com.okmyan.rickandmorty.domain.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersPagingDataSource(
    private val service: CharactersApi,
    private val lifeStatus: Optional<String>,
    private val infoMapper: InfoMapper,
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> =
        withContext(Dispatchers.IO) {
            val pageNumber = params.key ?: INITIAL_VALUE

            return@withContext try {

                val response = if (lifeStatus.isPresent) {
                    service.getCharacters(page = pageNumber, status = lifeStatus.get())
                } else {
                    service.getCharacters(page = pageNumber)
                }
                val pagedResponseDto = response.body() ?: ResponseInfoDto(null, null)
                val pagedResponse = infoMapper.mapResponseInfo(pagedResponseDto)

                val data = pagedResponse.results
                val nextPageNumber: Int? =
                    UriParser.parseNextOrPrevPageInUri(pagedResponse.info.nextPage)
                val prevPageNumber: Int? =
                    UriParser.parseNextOrPrevPageInUri(pagedResponse.info.prevPage)

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
