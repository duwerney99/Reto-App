package com.example.movies.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(val id: Int,
                     val user: String,
                     val email: String,
                     val password: String
                     ): Parcelable
