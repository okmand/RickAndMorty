package com.okmyan.gitusers.domain.usecases

import com.okmyan.gitusers.domain.repositories.DataRepository
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {

    fun getData(): String {
        return dataRepository.getData()
    }

}