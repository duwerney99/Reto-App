package com.example.movies.presentation.menu.nav.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.domain.model.InteractionModel
import com.example.movies.domain.usecase.interaction.GetInteractionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val interactionUseCase: GetInteractionsUseCase):
    ViewModel() {

    val interactionList: MutableLiveData<List<InteractionModel>> = MutableLiveData()

    fun getInteractions() {
        viewModelScope.launch(Dispatchers.IO) {
            val listInteractions = interactionUseCase()
            interactionList.postValue(listInteractions)
        }
    }
}