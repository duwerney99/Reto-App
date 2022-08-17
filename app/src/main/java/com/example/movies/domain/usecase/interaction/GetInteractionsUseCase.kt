package com.example.movies.domain.usecase.interaction

import com.example.movies.domain.model.InteractionModel


interface GetInteractionsUseCase {
    suspend operator fun invoke(): List<InteractionModel>
}