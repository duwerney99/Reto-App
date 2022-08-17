package com.example.movies.data.datasource.remote.network.dto

data class RandomsCollectionDTO (
    val page: Int?,
    val results: List<RandomDTO>? = listOf()
)