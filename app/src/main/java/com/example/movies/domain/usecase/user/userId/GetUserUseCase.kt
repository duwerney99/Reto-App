package com.example.movies.domain.usecase.user.userId

import com.example.movies.domain.model.UserModel

interface GetUserUseCase {

    suspend operator fun invoke(email: String, password: String): UserModel
}