package com.example.movies.data.repository

import com.example.movies.data.datasource.cache.CacheDataSource
import com.example.movies.data.datasource.remote.RemoteDataSource
import com.example.movies.data.mapper.toListInteraction
import com.example.movies.domain.model.InteractionModel
import com.example.movies.domain.respository.InteractionRepository
import javax.inject.Inject

class InteractionRepositoryImpl @Inject constructor(private val cacheDataSource: CacheDataSource): InteractionRepository {

    override suspend fun getInteractions(): List<InteractionModel> {
        return cacheDataSource.getInteractions().toListInteraction()
    }
}