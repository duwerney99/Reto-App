package com.example.movies.data.di

import com.example.movies.data.repository.InteractionRepositoryImpl
import com.example.movies.data.repository.MovieRepositoryImpl
import com.example.movies.data.repository.RandomRepositoryImpl
import com.example.movies.data.repository.UserRepositoryImpl
import com.example.movies.domain.respository.InteractionRepository
import com.example.movies.domain.respository.MovieRepository
import com.example.movies.domain.respository.RandomRepository
import com.example.movies.domain.respository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    @Singleton
    abstract fun bindInteractionRepository(interactionRepositoryImpl: InteractionRepositoryImpl): InteractionRepository


    @Binds
    @Singleton
    abstract fun bindRandomRepository(randomRepositoryImpl: RandomRepositoryImpl): RandomRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}