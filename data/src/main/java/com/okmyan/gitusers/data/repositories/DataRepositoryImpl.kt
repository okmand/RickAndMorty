package com.okmyan.gitusers.data.repositories

import com.okmyan.gitusers.data.DataService
import com.okmyan.gitusers.domain.repositories.DataRepository
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val dataService: DataService
) : DataRepository {

    override fun getData(): String {
        return dataService.getData()
    }

}