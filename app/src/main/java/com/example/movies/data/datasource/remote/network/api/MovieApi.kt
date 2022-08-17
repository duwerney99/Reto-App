package com.example.movies.data.datasource.remote.network.api

import com.example.movies.data.datasource.remote.network.dto.RandomsCollectionDTO
import com.example.movies.data.datasource.remote.network.dto.MovieCollectionDTO
import com.example.movies.data.datasource.remote.network.url.URL
import retrofit2.http.GET

interface MovieApi {

    @GET(URL.COLLECTION_MOVIES + URL.API_KEY)
    suspend fun getCollectionMovies(): MovieCollectionDTO

    @GET(URL.MOVIES_RAPTED + URL.API_KEY_RAPTED)
    suspend fun getRandoms(): RandomsCollectionDTO
}