package com.example.movies.domain.di

import com.example.movies.domain.usecase.interaction.GetInteractionsUseCase
import com.example.movies.domain.usecase.movie.GetMoviesUseCase
import com.example.movies.domain.usecase.random.GetRandomUseCase
import com.example.movies.domain.usecase.interaction.GetInteractionUseCaseImpl
import com.example.movies.domain.usecase.movie.GetMoviesUseCaseImpl
import com.example.movies.domain.usecase.random.GetRandomUseCaseImpl
import com.example.movies.domain.usecase.user.insert.GetInsertUserUseCase
import com.example.movies.domain.usecase.user.insert.GetInsertUserUseCaseImpl
import com.example.movies.domain.usecase.user.userId.GetUserUseCase
import com.example.movies.domain.usecase.user.userId.GetUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun  bindGetMoviesUseCase(getMoviesUseCaseImpl: GetMoviesUseCaseImpl): GetMoviesUseCase

    @Binds
    @Singleton
    abstract fun bindGetInteractionUseCase(getInteractionUseCaseImpl: GetInteractionUseCaseImpl): GetInteractionsUseCase

    @Binds
    @Singleton
    abstract fun bindGetRandomUseCase(getRandomUseCaseImpl: GetRandomUseCaseImpl): GetRandomUseCase

    @Binds
    @Singleton
    abstract fun bindGetRegisterUseCase(getInsertUserUseCaseImpl: GetInsertUserUseCaseImpl): GetInsertUserUseCase


    @Binds
    @Singleton
    abstract fun bindGetUserUseCase(getUserUseCaseImpl: GetUserUseCaseImpl): GetUserUseCase


}