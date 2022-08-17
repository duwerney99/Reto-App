package com.example.movies.data.mapper

import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.domain.model.UserModel

fun UserEntity?.toUserModel() : UserModel{
        return UserModel(this?.id ?: 0, this?.user ?: "", this?.email ?: "", this?.password ?: "")
}




