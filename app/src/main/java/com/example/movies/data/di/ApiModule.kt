package com.example.movies.data.di

import com.example.movies.data.datasource.remote.network.api.ApiProvider
import com.example.movies.data.datasource.remote.network.api.MovieApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideMovieApi(provider: ApiProvider): MovieApi =
        provider.create(MovieApi::class.java)



}