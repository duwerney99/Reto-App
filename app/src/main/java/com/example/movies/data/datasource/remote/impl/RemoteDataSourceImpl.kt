package com.example.movies.data.datasource.remote.impl

import com.example.movies.data.datasource.remote.RemoteDataSource
import com.example.movies.data.datasource.remote.network.api.MovieApi
import com.example.movies.data.datasource.remote.network.dto.MovieDTO
import com.example.movies.data.datasource.remote.network.dto.RandomDTO
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MovieApi): RemoteDataSource {

    override suspend fun getMovies(): List<MovieDTO> {
        return api.getCollectionMovies().items ?: listOf()
    }

    override suspend fun getRandoms(): List<RandomDTO> {
        return api.getRandoms().results ?: listOf()
    }
}