package com.genesis.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genesis.domain.GetHearthsUseCase
import com.genesis.presenter.model.HearthstoneUiModel
import kotlinx.coroutines.launch

class ClassCardViewModel(
    private val getGetHearthsUseCase: GetHearthsUseCase
) : ViewModel() {

    private val _getInfo = MutableLiveData<List<String>>()
    val getInfo = _getInfo as LiveData<List<String>>

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading as LiveData<Boolean>

    fun getInfo() {
        viewModelScope.launch {
            val infoList = getGetHearthsUseCase.invokeInfo()
            _getInfo.value = infoList
            _loading.value = false
        }
    }

}