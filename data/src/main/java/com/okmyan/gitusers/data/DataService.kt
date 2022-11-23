package com.okmyan.gitusers.data

interface DataService {

    fun getData(): String

}

fun DataService(info: String): DataService {

    return object : DataService {

        override fun getData(): String {
            return "${TEXT}_${info}"
        }

    }

}

private const val TEXT = "TEXT"