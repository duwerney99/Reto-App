package com.example.movies.data.mapper

import com.example.movies.data.datasource.remote.network.dto.MovieDTO
import com.example.movies.data.datasource.remote.network.url.URL.IMAGES_URL
import io.mockk.coVerify
import junit.framework.Assert.assertEquals
import org.junit.Test

class UserEntityMapperTest {


    @Test
    fun `If movie dto contains all values as null then all valuesshould be replaced with an empty string`() {
        // Given
        val movieDTO = MovieDTO(null, null, null, null, null, null)

        // When
        //methodName_scenarioToTest_expectedBehavior (BUSCAR)
        val movieModel = movieDTO.toMovieModel()

        // Then
        assertEquals("", movieModel.title)
        assertEquals("", movieModel.overview)
        assertEquals(IMAGES_URL + null, movieModel.posterUrlPath)
        assertEquals("", movieModel.release_date)
        assertEquals("", movieModel.original_title)
        assertEquals(IMAGES_URL + null, movieModel.backdrop_path)
    }
}