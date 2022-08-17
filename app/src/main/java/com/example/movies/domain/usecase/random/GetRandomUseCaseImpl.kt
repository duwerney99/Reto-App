package com.example.movies.domain.usecase.random

import com.example.movies.domain.model.RandomModel
import com.example.movies.domain.respository.RandomRepository
import com.example.movies.domain.usecase.random.GetRandomUseCase
import javax.inject.Inject


class GetRandomUseCaseImpl @Inject constructor(private val randomRepository: RandomRepository):
    GetRandomUseCase {

    override suspend operator fun invoke(): List<RandomModel> {
        return randomRepository.getRandoms()
    }
}