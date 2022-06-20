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

    private val _infoList = MutableLiveData<List<String>>()
    val infoLiveData = _infoList as LiveData<List<String>>

    private val _loadingLiveDate = MutableLiveData<Boolean>()
    val loadingLiveDate = _loadingLiveDate as LiveData<Boolean>

    fun getInfo() {
        viewModelScope.launch {
            val infoList = getGetHearthsUseCase.invokeInfo()
            _infoList.value = infoList
            _loadingLiveDate.value = false
        }
    }

}