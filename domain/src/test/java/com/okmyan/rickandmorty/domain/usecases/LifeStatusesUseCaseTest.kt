package com.okmyan.rickandmorty.domain.usecases

import com.okmyan.rickandmorty.domain.models.AliveStatus
import com.okmyan.rickandmorty.domain.models.DeadStatus
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.models.UnknownStatus
import com.okmyan.rickandmorty.domain.repositories.LifeStatusesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@RunWith(Parameterized::class)
class LifeStatusesUseCaseTest(
    private val lifeStatusesFlow: Flow<List<LifeStatus>>,
    private val expectedResult: List<String>,
) {

    private val repository = mock<LifeStatusesRepository> {
        onBlocking { getLifeStatuses() } doReturn lifeStatusesFlow
    }

    private val useCase = LifeStatusesUseCase(repository)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Check LifeStatuses use case`(): Unit = runTest {

        val deferred = async {
            val asyncResult = mutableListOf<String>()

            useCase.execute().onEach { statuses ->
                asyncResult.addAll(statuses)
            }.collect()

            asyncResult
        }
        val actualResult = deferred.await()

        assertThat(actualResult).isEqualTo(expectedResult)
    }

    companion object {
        @Parameterized.Parameters(name = "{index}: {0} -> {1}")
        @JvmStatic
        fun parameters() = listOf(

            // 0
            arrayOf(
                flowOf(listOf(AliveStatus(), UnknownStatus(), DeadStatus())),
                listOf(
                    LifeStatus.EMPTY_VALUE, LifeStatus.STATUS_ALIVE,
                    LifeStatus.STATUS_UNKNOWN, LifeStatus.STATUS_DEAD,
                )
            ),

            // 1
            arrayOf(
                flowOf(listOf(AliveStatus(), DeadStatus())),
                listOf(LifeStatus.EMPTY_VALUE, LifeStatus.STATUS_ALIVE, LifeStatus.STATUS_DEAD)
            ),

            // 2
            arrayOf(
                flowOf(listOf(UnknownStatus())),
                listOf(LifeStatus.EMPTY_VALUE, LifeStatus.STATUS_UNKNOWN)
            ),

            // 3
            arrayOf(
                flowOf(listOf<LifeStatus>()),
                listOf(LifeStatus.EMPTY_VALUE)
            ),

            )

    }

}
