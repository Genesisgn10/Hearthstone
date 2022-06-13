package com.genesis.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genesis.domain.GetHearthsUseCase
import com.genesis.presenter.model.CategoryUiModel
import com.genesis.presenter.model.HearthstoneUiModel
import kotlinx.coroutines.launch

class MealViewModel(
    private val getGetHearthsUseCase: GetHearthsUseCase
) : ViewModel() {

    private val _hearthstone = MutableLiveData<List<HearthstoneUiModel>>()
    val hearthstone = _hearthstone as LiveData<List<HearthstoneUiModel>>

    private val _getInfo = MutableLiveData<List<String>>()
    val getInfo = _getInfo as LiveData<List<String>>

    private val _categories = MutableLiveData<List<CategoryUiModel>>()
    val categories = _categories as LiveData<List<CategoryUiModel>>

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading as LiveData<Boolean>

    fun get() {
        viewModelScope.launch {
            //val hearthstoneList = getGetHearthsUseCase()
           // _hearthstone.value = hearthstoneList.map { hearthstone ->
             //   hearthstone.toUiModel()
            //}
        }
    }

    fun getInfo() {
        viewModelScope.launch {
            val infoList = getGetHearthsUseCase.invokeInfo()
            _getInfo.value = infoList
            _loading.value = false
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            // val categoryList = getCategoriesUseCase()
            // Log.e("asd", categoryList.toString())
            // _categories.value = categoryList.map { category ->
            //category.toUiModel()
        }
    }
}

