package com.example.movies.data.datasource.remote.network.dto

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("title")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val poster_path: String?,
    @SerializedName("release_date")
    val release_date: String?,
    @SerializedName("original_title")
    val original_title: String?,
    @SerializedName("backdrop_path")
    val backdrop_path: String?
)