package com.example.movies.data.datasource.cache

import com.example.movies.data.datasource.remote.network.dto.InteractionsDTO
import com.example.movies.data.datasource.remote.network.dto.MovieDTO

interface CacheDataSource {
    fun getMovies(): List<MovieDTO>
    fun getInteractions(): List<InteractionsDTO>
}