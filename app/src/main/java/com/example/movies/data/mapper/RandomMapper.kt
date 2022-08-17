package com.example.movies.data.mapper

import com.example.movies.data.datasource.remote.network.dto.InteractionsDTO
import com.example.movies.data.datasource.remote.network.dto.RandomDTO
import com.example.movies.data.datasource.remote.network.url.URL
import com.example.movies.domain.model.InteractionModel
import com.example.movies.domain.model.RandomModel

fun RandomDTO.toRandomModel() = RandomModel(
    URL.IMAGES_URL + this.poster_path ?: "", this.original_title ?:""
)

fun List<RandomDTO>.toListRandom() = this.map { it.toRandomModel() }