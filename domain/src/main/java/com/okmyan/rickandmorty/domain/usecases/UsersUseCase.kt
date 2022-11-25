package com.okmyan.rickandmorty.domain.usecases

import com.okmyan.rickandmorty.domain.repositories.DataRepository
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {

    fun getData(): String {
        return dataRepository.getData()
    }

}