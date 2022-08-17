package com.example.movies.domain.respository

import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.domain.model.UserModel

interface UserRepository {

    suspend fun getUserByUser(email: String, password: String): UserModel

    suspend fun insertUser(userEntity: UserEntity)

}