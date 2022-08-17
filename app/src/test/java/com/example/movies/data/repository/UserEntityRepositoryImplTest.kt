package com.example.movies.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies.data.datasource.remote.RemoteDataSource
import com.example.movies.data.datasource.remote.network.dto.MovieDTO
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
class UserEntityRepositoryImplTest {


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var remoteDataSource: RemoteDataSource

    @InjectMockKs
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `MovieRepositoryImpl() should call getMovies() from RemoteDataSource()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf<MovieDTO>()

            coEvery { remoteDataSource.getMovies() } returns expectedResult

            // When
            movieRepositoryImpl.getMovies()

            // Then
            coVerify { remoteDataSource.getMovies() }
        }
}