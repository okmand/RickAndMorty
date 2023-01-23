package com.okmyan.rickandmorty.data.mappers

import com.okmyan.rickandmorty.domain.models.AliveStatus
import com.okmyan.rickandmorty.domain.models.DeadStatus
import com.okmyan.rickandmorty.domain.models.LifeStatus
import com.okmyan.rickandmorty.domain.models.UnknownStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class LifeStatusMapperTest(
    private val lifeStatus: String,
    private val expectedResult: LifeStatus,
) {

    private val mapper = LifeStatusMapper

    @Test
    fun `Check LifeStatus mapper`() {
        val actualResult = mapper.mapLifeStatus(lifeStatus)
        assertThat(expectedResult).isEqualTo(actualResult)
    }

    companion object {
        @Parameterized.Parameters(name = "{index}: {0} -> {1}")
        @JvmStatic
        fun parameters() = listOf(

            // 0
            arrayOf(
                LifeStatus.STATUS_ALIVE,
                AliveStatus(),
            ),

            // 1
            arrayOf(
                LifeStatus.STATUS_DEAD,
                DeadStatus(),
            ),

            // 2
            arrayOf(
                "something",
                UnknownStatus(),
            ),

            )
    }


}
