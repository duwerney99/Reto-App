package com.example.movies.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(val title: String,
                      val overview: String,
                      val posterUrlPath: String,
                      val release_date: String,
                      val original_title: String,
                      val backdrop_path: String): Parcelable
