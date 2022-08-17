package com.example.movies.domain.usecase.movie

import com.example.movies.domain.model.MovieModel
import com.example.movies.domain.respository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository):
    GetMoviesUseCase {

    override suspend operator fun invoke(): List<MovieModel> {
        return movieRepository.getMovies()
    }
}