package com.example.movies.data.datasource.local

import com.example.movies.data.datasource.local.room.dao.UserEntity

interface DataBaseDataSource {

    suspend fun getUserByUser(email: String, password: String): UserEntity?

    suspend fun insertUser(userEntity: UserEntity)

}