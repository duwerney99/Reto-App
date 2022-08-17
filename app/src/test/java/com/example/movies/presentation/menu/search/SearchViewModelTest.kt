package com.example.movies.presentation.menu.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies.domain.model.MovieModel
import com.example.movies.domain.usecase.movie.GetMoviesUseCase
import com.example.movies.presentation.menu.nav.search.SearchViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getMoviesUseCase: GetMoviesUseCase

    @InjectMockKs
    private lateinit var viewModel: SearchViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getMovies should call getMoviesUseCase()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<MovieModel>())

            coEvery { getMoviesUseCase() } returns expectedResult

            // When
            viewModel.getMovies()

            // Then
            coVerify { getMoviesUseCase() }
        }


    @Test
    fun `getMovies should emit movie list with data status through a liveData when getMoviesUseCase`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<MovieModel>())

            coEvery { getMoviesUseCase() } returns expectedResult

            // When
            viewModel.getMovies()
            val result = viewModel.moviesList.value

            // Then
            Assert.assertEquals(expectedResult, result)
        }
}