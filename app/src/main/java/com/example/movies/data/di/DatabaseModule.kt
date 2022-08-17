package com.example.movies.data.di

import android.content.Context
import androidx.room.Room
import com.example.movies.data.datasource.local.room.UserRoomDatabase
import com.example.movies.data.datasource.local.room.dao.UserDAO
import com.example.movies.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideUserDao(userRoomDatabase: UserRoomDatabase): UserDAO {
        return userRoomDatabase.userDAO()
    }

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        UserRoomDatabase::class.java,
        DATABASE_NAME
    ).build()
}