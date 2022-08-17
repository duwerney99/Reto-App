package com.example.movies.presentation.menu.nav.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.domain.model.MovieModel
import com.example.movies.domain.usecase.movie.GetMoviesUseCase
import com.example.movies.presentation.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO

) :
    ViewModel() {

    val moviesList: MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch(dispatcher) {
            val listMovies = getMoviesUseCase()
            moviesList.postValue(listMovies)
        }
    }


}