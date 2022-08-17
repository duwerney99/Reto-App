package com.example.movies.data.repository

import com.example.movies.data.datasource.remote.RemoteDataSource
import com.example.movies.data.mapper.toListMovieModel
import com.example.movies.domain.model.MovieModel
import com.example.movies.domain.respository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): MovieRepository {

    override suspend fun getMovies(): List<MovieModel> {
        return remoteDataSource.getMovies().toListMovieModel()
    }
}