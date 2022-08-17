package com.example.movies.data.datasource.local.room.dao

import androidx.room.*

@Dao
interface UserDAO {

    @Query("SELECT * FROM user WHERE email = :email AND password = :password LIMIT 1")
    suspend fun getUserByUser(email: String, password: String): UserEntity?


    @Query("INSERT INTO user (user, email, password) VALUES(:user,:email,:password)")
    suspend fun insertUser(user:String, email:String, password:String)

}