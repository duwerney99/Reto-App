package com.example.movies.data.datasource.cache.impl

import com.example.movies.data.datasource.cache.CacheDataSource
import com.example.movies.data.datasource.remote.network.dto.InteractionsDTO
import com.example.movies.data.datasource.remote.network.dto.MovieDTO
import javax.inject.Inject

class CacheDataSourceImpl @Inject constructor() : CacheDataSource {

    override fun getMovies(): List<MovieDTO> {
        return listOf()
    }

    override fun getInteractions(): List<InteractionsDTO> {
        return listOf(
            InteractionsDTO("Calificar y obtener recomendaciones", "Calificaciones", 0),
            InteractionsDTO("Agregar a listas", "Listas", 4)
        )
    }
}