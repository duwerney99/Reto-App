package com.example.movies.presentation.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.datasource.local.room.dao.UserEntity
import com.example.movies.domain.model.UserModel
import com.example.movies.domain.usecase.user.userId.GetUserUseCase
import com.example.movies.presentation.di.IoDispatcher
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO

) :
    ViewModel() {

    val userData : MutableLiveData<UserModel> = MutableLiveData()

    fun loginUser(email: String, password: String) {
        viewModelScope.launch(dispatcher) {
            val userValue = getUserUseCase(email, password)
            userData.postValue(userValue)
        }
    }

}


