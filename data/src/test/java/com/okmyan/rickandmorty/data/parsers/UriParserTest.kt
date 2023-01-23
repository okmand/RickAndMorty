package com.okmyan.rickandmorty.data.parsers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UriParserTest {

    private val parser = UriParser

    @Test
    fun `Check Uri parser with value`() {
        val actualResult = parser.parseNextOrPrevPageInUri(URI_STRING_WITH_VALUE)
        assertThat(actualResult).isEqualTo(VALUE_IN_URI_STRING)
    }

    @Test
    fun `Check Uri parser without value`() {
        val actualResult = parser.parseNextOrPrevPageInUri(URI_STRING_WITHOUT_VALUE)
        assertThat(actualResult).isEqualTo(null)
    }

    companion object {

        private const val VALUE_IN_URI_STRING = 3
        private const val URI_STRING_WITH_VALUE = "https://rickandmortyapi.com/api/character?page=3"
        private const val URI_STRING_WITHOUT_VALUE =
            "https://rickandmortyapi.com/api/character?page="

    }

}
