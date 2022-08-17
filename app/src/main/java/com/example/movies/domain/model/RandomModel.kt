package com.example.movies.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RandomModel(val posterUrlPath: String, val original_title: String): Parcelable
