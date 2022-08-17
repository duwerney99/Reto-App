package com.example.movies.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InteractionModel(val recommendation: String, val interaction: String, val numberInteraction: Int): Parcelable
