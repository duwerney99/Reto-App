package com.example.movies.presentation.authentication.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.domain.usecase.user.insert.GetInsertUserUseCase
import com.example.movies.presentation.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getInsertUserUseCase: GetInsertUserUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO

) :
    ViewModel() {


    fun insertUser(userEntity: UserEntity) {
        viewModelScope.launch(dispatcher) {
            getInsertUserUseCase(userEntity)
        }
    }

}

