package com.example.movies.data.datasource.local.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.data.datasource.local.room.dao.UserDAO


@Database(
    entities = [UserEntity::class],
    version = 2,
    exportSchema = false
)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
}