package com.genesis.presenter

import com.genesis.domain.GetHearthsUseCase
import com.genesis.presenter.viewmodel.ClassCardViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class HearthstoneViewModel {

    private val useCase = mockk<GetHearthsUseCase>()

    private val viewModel = ClassCardViewModel(useCase)

    @Test
    fun getClassCards_return_list_with_failed() = runBlocking {
        //GIVEN
        coEvery { useCase.invokeInfo() } returns CarSetFactory.set

        //WHEN
        viewModel.getInfo()
        val value = viewModel.getInfo.value

        //THEN
        assert(value == null)
    }

}