package com.example.movies.domain.usecase.user.insert

import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.domain.respository.UserRepository
import javax.inject.Inject

class GetInsertUserUseCaseImpl  @Inject constructor(private val userRepository: UserRepository):
    GetInsertUserUseCase{

    override suspend operator fun invoke(userEntity: UserEntity){
        userRepository.insertUser(userEntity)
    }
}