package com.example.movies.domain.usecase.interaction

import com.example.movies.data.repository.InteractionRepositoryImpl
import com.example.movies.domain.model.InteractionModel
import com.example.movies.domain.usecase.interaction.GetInteractionsUseCase
import javax.inject.Inject


class GetInteractionUseCaseImpl @Inject constructor(private val interactionRepositoryImpl: InteractionRepositoryImpl):
    GetInteractionsUseCase {

    override suspend operator fun invoke(): List<InteractionModel> {
        return interactionRepositoryImpl.getInteractions()
    }
}