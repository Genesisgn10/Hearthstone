package com.genesis.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genesis.domain.GetHearthsUseCase
import kotlinx.coroutines.launch

class SetCardViewModel(
    private val getGetHearthsUseCase: GetHearthsUseCase
) : ViewModel() {

    private val _infoLiveData = MutableLiveData<List<String>>()
    val infoLiveData = _infoLiveData as LiveData<List<String>>

    private val _loadingLiveDate = MutableLiveData<Boolean>()
    val loadingLiveDate = _loadingLiveDate as LiveData<Boolean>

    fun getInfo() {
        viewModelScope.launch {
            val infoList = getGetHearthsUseCase.invokeInfo()
            _infoLiveData.value = infoList
            _loadingLiveDate.value = false
        }
    }

}