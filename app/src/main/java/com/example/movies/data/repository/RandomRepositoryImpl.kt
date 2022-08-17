package com.example.movies.data.repository

import com.example.movies.data.datasource.remote.RemoteDataSource
import com.example.movies.data.mapper.toListRandom
import com.example.movies.domain.model.RandomModel
import com.example.movies.domain.respository.RandomRepository
import javax.inject.Inject

class RandomRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): RandomRepository {

    override suspend fun getRandoms(): List<RandomModel> {
        return remoteDataSource.getRandoms().toListRandom()
    }
}