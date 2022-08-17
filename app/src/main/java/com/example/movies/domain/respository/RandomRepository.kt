package com.example.movies.domain.respository

import com.example.movies.domain.model.RandomModel

interface RandomRepository {

    suspend fun getRandoms(): List<RandomModel>
}