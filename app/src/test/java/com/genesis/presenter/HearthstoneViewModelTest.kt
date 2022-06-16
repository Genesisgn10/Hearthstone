package com.genesis.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.genesis.domain.GetHearthsUseCase
import com.genesis.util.extensios.getOrAwaitValue
import com.genesis.presenter.viewmodel.SetCardViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class HearthstoneViewModelTest {

    private val useCase = mockk<GetHearthsUseCase>()

    private val viewModel = SetCardViewModel(useCase)

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun getInfo_return_list_with_sucess() = runBlocking {
        val observer = Observer<List<String>> {}
        try {
            //GIVEN
            coEvery { useCase.invokeInfo() } returns SetCardFactory.set
            // THEN
            viewModel.getInfo()
            val value = viewModel.infoLiveData.getOrAwaitValue()
            //WHEN
            assertEquals(value.size, SetCardFactory.set.size)
        } finally {
            viewModel.infoLiveData.removeObserver(observer)
        }
    }

    @Test
    fun getInfo_return_exception() = runBlocking {
        val observer = Observer<List<String>> {}
        try {
            //GIVEN
            coEvery { useCase.invokeInfo() } returns listOf()

            //THEN
            viewModel.getInfo()
            val value = viewModel.infoLiveData.getOrAwaitValue()

            // WHEN
            assertEquals(value.size, 0)
        } finally {
            viewModel.infoLiveData.removeObserver(observer)
        }
    }
}