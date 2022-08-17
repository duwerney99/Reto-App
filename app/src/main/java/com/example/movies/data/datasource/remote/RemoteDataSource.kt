package com.example.movies.data.datasource.remote

import com.example.movies.data.datasource.remote.network.dto.MovieDTO
import com.example.movies.data.datasource.remote.network.dto.RandomDTO

interface RemoteDataSource{

    suspend fun getMovies(): List<MovieDTO>

    suspend fun getRandoms(): List<RandomDTO>
}