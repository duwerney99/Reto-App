package com.example.movies.domain.usecase.user.userId

import com.example.movies.domain.model.UserModel
import com.example.movies.domain.respository.UserRepository
import javax.inject.Inject


class GetUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository):
    GetUserUseCase{

    override suspend operator fun invoke(email: String, password: String): UserModel {
        return userRepository.getUserByUser(email, password)
    }
}