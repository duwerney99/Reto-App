package com.example.movies.data.datasource.remote.network.dto

data class MovieCollectionDTO (
    val created_by: String?,
    val description: String?,
    val favorite_count: Int?,
    val id:String?,
    val items: List<MovieDTO>? = listOf()
)