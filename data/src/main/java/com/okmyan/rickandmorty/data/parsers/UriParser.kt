package com.okmyan.rickandmorty.data.parsers

import android.net.Uri
import com.okmyan.rickandmorty.data.constants.HttpAttributes.Companion.FIELD_PAGE

object UriParser {

    fun parseNextOrPrevPageInUri(uriString: String): Int? {
        val nextOrPrevPageQuery = Uri.parse(uriString).getQueryParameter(FIELD_PAGE)
        return nextOrPrevPageQuery?.toIntOrNull()
    }

}
