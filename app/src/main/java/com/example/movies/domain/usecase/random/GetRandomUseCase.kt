package com.example.movies.domain.usecase.random

import com.example.movies.domain.model.RandomModel


interface GetRandomUseCase {
    suspend operator fun invoke(): List<RandomModel>
}