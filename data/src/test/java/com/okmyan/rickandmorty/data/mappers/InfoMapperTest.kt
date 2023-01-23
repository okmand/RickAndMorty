package com.okmyan.rickandmorty.data.mappers

import com.okmyan.rickandmorty.data.dto.CharacterDto
import com.okmyan.rickandmorty.data.dto.InfoDto
import com.okmyan.rickandmorty.data.dto.ResponseInfoDto
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_0
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_1
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_2
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_DTO_0
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_DTO_1
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_DTO_2
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_STATUS_0
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_STATUS_1
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_STATUS_2
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_STATUS_IN_STRING_0
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.CHARACTER_STATUS_IN_STRING_1
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.INFO_0
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.INFO_1
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.INFO_2
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.INFO_DTO_0
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.INFO_DTO_1
import com.okmyan.rickandmorty.data.mappers.InfoMapperTestEntity.INFO_DTO_2
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.models.Info
import com.okmyan.rickandmorty.domain.models.ResponseInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@RunWith(Parameterized::class)
class InfoMapperTest(
    private val infoDto: InfoDto,
    private val resultsDto: List<CharacterDto?>,
    private val info: Info,
    private val results: List<Character>,
) {

    private val lifeStatusMapper = mock<LifeStatusMapper> {
        on { mapLifeStatus(anyString()) } doReturn CHARACTER_STATUS_2
        on { mapLifeStatus(CHARACTER_STATUS_IN_STRING_0) } doReturn CHARACTER_STATUS_0
        on { mapLifeStatus(CHARACTER_STATUS_IN_STRING_1) } doReturn CHARACTER_STATUS_1
    }

    private val infoMapper = InfoMapper(lifeStatusMapper)

    @Test
    fun `Check Info mapper`() {
        val responseInfoDto = ResponseInfoDto(infoDto, resultsDto)

        val expectedResult = ResponseInfo(info, results)

        val actualResult = infoMapper.mapResponseInfo(responseInfoDto)

        assertThat(expectedResult).isEqualTo(actualResult)
    }

    companion object {
        @Parameterized.Parameters(name = "{index}: {0} and {1} -> {2} and {3}")
        @JvmStatic
        fun parameters() = listOf(

            // 0
            arrayOf(
                INFO_DTO_0,
                listOf(CHARACTER_DTO_0),
                INFO_0,
                listOf(CHARACTER_0),
            ),

            // 1
            arrayOf(
                INFO_DTO_1,
                listOf(CHARACTER_DTO_1),
                INFO_1,
                listOf(CHARACTER_1),
            ),

            // 2
            arrayOf(
                INFO_DTO_2,
                listOf(CHARACTER_DTO_2),
                INFO_2,
                listOf(CHARACTER_2),
            ),

            // 3
            arrayOf(
                INFO_DTO_0,
                listOf(CHARACTER_DTO_0, CHARACTER_DTO_1),
                INFO_0,
                listOf(CHARACTER_0, CHARACTER_1),
            ),

            // 4
            arrayOf(
                INFO_DTO_1,
                listOf(CHARACTER_DTO_0, CHARACTER_DTO_2),
                INFO_1,
                listOf(CHARACTER_0, CHARACTER_2),
            ),

            // 5
            arrayOf(
                INFO_DTO_2,
                listOf(CHARACTER_DTO_1, CHARACTER_DTO_2),
                INFO_2,
                listOf(CHARACTER_1, CHARACTER_2),
            ),

            // 6
            arrayOf(
                INFO_DTO_0,
                listOf(CHARACTER_DTO_0, CHARACTER_DTO_1, CHARACTER_DTO_2),
                INFO_0,
                listOf(CHARACTER_0, CHARACTER_1, CHARACTER_2),
            ),

            )
    }

}
