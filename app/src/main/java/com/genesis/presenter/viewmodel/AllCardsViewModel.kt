package com.genesis.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genesis.domain.GetHearthsUseCase
import com.genesis.presenter.model.HearthstoneUiModel
import com.genesis.presenter.model.toUiModel
import kotlinx.coroutines.launch

class AllCardsViewModel(
    private val getGetHearthsUseCase: GetHearthsUseCase
) : ViewModel() {

    private val _getCards = MutableLiveData<List<HearthstoneUiModel>>()
    val getCards = _getCards as LiveData<List<HearthstoneUiModel>>

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading as LiveData<Boolean>

    fun getAllCards(classe: String) {
        _loading.value = true
        viewModelScope.launch {
            val resultLIst = getGetHearthsUseCase.invoke(classe)
            _getCards.value = resultLIst.map { list ->
                list.toUiModel()
            }
            _loading.value = false
        }
    }
}