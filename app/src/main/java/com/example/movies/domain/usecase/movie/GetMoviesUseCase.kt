package com.example.movies.domain.usecase.movie

import com.example.movies.domain.model.MovieModel


interface GetMoviesUseCase {
    suspend operator fun invoke(): List<MovieModel>
}