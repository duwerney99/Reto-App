package com.example.movies.data.mapper

import com.example.movies.data.datasource.remote.network.dto.MovieDTO
import com.example.movies.data.datasource.remote.network.url.URL.IMAGES_URL
import com.example.movies.domain.model.MovieModel

fun MovieDTO.toMovieModel() = MovieModel(this.title ?: "", this.overview ?: "", IMAGES_URL + this.poster_path, this.release_date ?: "", this.original_title ?: "", IMAGES_URL + this.backdrop_path)

fun List<MovieDTO>.toListMovieModel() = this.map { it.toMovieModel() }




