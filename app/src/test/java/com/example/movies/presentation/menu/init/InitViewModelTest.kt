package com.example.movies.presentation.menu.init

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies.domain.model.RandomModel
import com.example.movies.domain.usecase.random.GetRandomUseCase
import com.example.movies.presentation.menu.nav.init.InitViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class InitViewModelTest {


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var testCoroutineDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getRandomUseCase: GetRandomUseCase

    @InjectMockKs
    private lateinit var viewModel: InitViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getRandoms should call getRandomUseCase()`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<RandomModel>())

            coEvery { getRandomUseCase() } returns expectedResult

            // When
            viewModel.getRandoms()

            // Then
            coVerify { getRandomUseCase() }
        }


    @Test
    fun `getRandoms should emit movie list with data status through a liveData when getRandomUseCase`() =
        runBlockingTest {
            // Given
            val expectedResult = listOf(mockk<RandomModel>())

            coEvery { getRandomUseCase() } returns expectedResult

            // When
            viewModel.getRandoms()
            val result = viewModel.randomList.value

            // Then
            Assert.assertEquals(expectedResult, result)
        }
}