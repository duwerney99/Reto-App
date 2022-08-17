package com.example.movies.data.mapper

import com.example.movies.data.datasource.remote.network.dto.InteractionsDTO
import com.example.movies.domain.model.InteractionModel

fun InteractionsDTO.toInteractionModel() = InteractionModel(
    this.recommendation ?: "", this.interaction ?:"",
    (this.numberInteraction ?:"") as Int
)

fun List<InteractionsDTO>.toListInteraction() = this.map { it.toInteractionModel() }