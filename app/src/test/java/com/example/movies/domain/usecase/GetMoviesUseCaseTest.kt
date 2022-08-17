package com.example.movies.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies.domain.model.MovieModel
import com.example.movies.domain.respository.MovieRepository
import com.example.movies.domain.usecase.movie.GetMoviesUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetMoviesUseCaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var movieRepository: MovieRepository

    @InjectMockKs
    private lateinit var getMoviesUseCaseImpl: GetMoviesUseCaseImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getMoviesUseCaseImpl should call movieRepository getMovies()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<MovieModel>())

            coEvery { movieRepository.getMovies() } returns expectedResult

            // When
            getMoviesUseCaseImpl()

            // Then
            coVerify { movieRepository.getMovies() }
        }


}