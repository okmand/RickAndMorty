package com.okmyan.rickandmorty.domain.usecases

import androidx.paging.PagingData
import com.google.common.base.Optional
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.repositories.CharactersRepository
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCaseTestEntity.CHARACTER_0
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCaseTestEntity.CHARACTER_1
import com.okmyan.rickandmorty.domain.usecases.CharactersUseCaseTestEntity.CHARACTER_2
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@RunWith(Parameterized::class)
class CharactersUseCaseTest(
    private val pagingDataFlow: Flow<PagingData<Character>>,
    private val optionalLifeStatus: Optional<String>,
) {

    private val repository = mock<CharactersRepository> {
        onBlocking { getCharacters(optionalLifeStatus) } doReturn pagingDataFlow
    }

    private val useCase = CharactersUseCase { repository }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Check Characters useCase`() = runTest {
        val lifeStatus = if (optionalLifeStatus.isPresent) {
            optionalLifeStatus.get()
        } else {
            ""
        }
        val actualResult = useCase.getCharacters(lifeStatus)
        assertThat(actualResult).isEqualTo(pagingDataFlow)
    }

    companion object {
        @Parameterized.Parameters(name = "{index}: {0}, {1} -> {0}")
        @JvmStatic
        fun parameters() = listOf(

            // 0
            arrayOf(
                flowOf(
                    PagingData.from(
                        listOf(CHARACTER_0, CHARACTER_1, CHARACTER_2)
                    )
                ),
                Optional.absent<String>()
            ),

            // 1
            arrayOf(
                flowOf(
                    PagingData.from(
                        listOf(CHARACTER_0, CHARACTER_1)
                    )
                ),
                Optional.fromNullable("Some value")
            ),

            // 2
            arrayOf(
                flowOf(
                    PagingData.from(
                        listOf()
                    )
                ),
                Optional.fromNullable("Some value")
            ),

            )

    }

}
