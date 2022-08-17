package com.example.movies.domain.usecase.user.insert

import com.example.movies.data.datasource.local.room.dao.UserEntity


interface GetInsertUserUseCase {
    suspend operator fun invoke(userEntity: UserEntity)
}