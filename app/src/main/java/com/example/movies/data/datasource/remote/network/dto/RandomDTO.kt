package com.example.movies.data.datasource.remote.network.dto

import com.google.gson.annotations.SerializedName

data class RandomDTO (
        @SerializedName("poster_path")
        val poster_path: String?,
        @SerializedName("original_title")
        val original_title: String?
)