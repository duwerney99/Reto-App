package com.example.movies.domain.respository

import com.example.movies.domain.model.InteractionModel

interface InteractionRepository {

    suspend fun getInteractions(): List<InteractionModel>
}