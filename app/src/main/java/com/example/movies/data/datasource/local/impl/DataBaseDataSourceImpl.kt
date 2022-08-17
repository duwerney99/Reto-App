package com.example.movies.data.datasource.local.impl

import com.example.movies.data.datasource.local.DataBaseDataSource
import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.data.datasource.local.room.dao.UserDAO
import javax.inject.Inject

class DataBaseDataSourceImpl @Inject constructor(private val userDAO: UserDAO): DataBaseDataSource {

    override suspend fun getUserByUser(email: String, password: String): UserEntity? {
        return userDAO.getUserByUser(email, password)
    }

    override suspend fun insertUser(userEntity: UserEntity) {
        userDAO.insertUser(userEntity.user, userEntity.email, userEntity.password)
    }


}