package com.okmyan.rickandmorty.data.repositories

import com.okmyan.rickandmorty.data.DataService
import com.okmyan.rickandmorty.domain.repositories.DataRepository
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val dataService: DataService
) : DataRepository {

    override fun getData(): String {
        return dataService.getData()
    }

}