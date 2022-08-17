package com.example.movies.data.repository

import com.example.movies.data.datasource.local.DataBaseDataSource
import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.data.mapper.toUserModel
import com.example.movies.domain.model.UserModel
import com.example.movies.domain.respository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl  @Inject constructor(private val dataBaseDataSource: DataBaseDataSource): UserRepository {

    override suspend fun getUserByUser(email: String, password: String): UserModel {
        return dataBaseDataSource.getUserByUser(email, password).toUserModel()
    }

    override suspend fun insertUser(userEntity: UserEntity) {
        dataBaseDataSource.insertUser(userEntity)
    }
}