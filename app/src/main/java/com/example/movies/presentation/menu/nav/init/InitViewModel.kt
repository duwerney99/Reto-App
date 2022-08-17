package com.example.movies.presentation.menu.nav.init

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.domain.model.RandomModel
import com.example.movies.domain.usecase.random.GetRandomUseCase
import com.example.movies.presentation.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    private val getRandomUseCase: GetRandomUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    ViewModel() {

    val randomList: MutableLiveData<List<RandomModel>> = MutableLiveData()

    fun getRandoms() {
        viewModelScope.launch(dispatcher) {
            val listRandoms = getRandomUseCase()
            randomList.postValue(listRandoms)
        }
    }
}