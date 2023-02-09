package com.okmyan.rickandmorty.data.repositories

import com.okmyan.rickandmorty.data.services.LifeStatusesService
import com.okmyan.rickandmorty.domain.models.AliveStatus
import com.okmyan.rickandmorty.domain.models.DeadStatus
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.models.UnknownStatus
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
class LifeStatusesRepositoryImplTest(
    private val lifeStatusesFlow: Flow<List<LifeStatus>>,
) {

    private val service = mock<LifeStatusesService> {
        on { getLifeStatuses() } doReturn lifeStatusesFlow
    }

    private val repository = LifeStatusesRepositoryImpl(service)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Check LifeStatuses repository`(): Unit = runTest {
        val actualResult = repository.getLifeStatuses()
        assertThat(actualResult).isEqualTo(lifeStatusesFlow)
    }

    companion object {
        @Parameterized.Parameters(name = "{index}")
        @JvmStatic
        fun parameters() = listOf(

            // 0
            arrayOf(
                flowOf(
                    listOf(AliveStatus(), UnknownStatus(), DeadStatus())
                )
            ),

            // 1
            arrayOf(
                flowOf(
                    listOf(AliveStatus(), DeadStatus())
                )
            ),

            // 2
            arrayOf(
                flowOf(
                    listOf(UnknownStatus())
                )
            ),

            )

    }

}
