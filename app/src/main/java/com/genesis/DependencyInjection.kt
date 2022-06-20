package com.genesis

import com.genesis.data.HearthstoneRepository
import com.genesis.data.HearthstoneRepositoryImpl
import com.genesis.data.api.HearthstoneApi
import com.genesis.domain.GetHearths
import com.genesis.domain.GetHearthsUseCase
import com.genesis.network.Service
import com.genesis.presenter.viewmodel.AllCardsViewModel
import com.genesis.presenter.viewmodel.SetCardViewModel
import org.koin.dsl.module

val HearthstoneServiceModule = module {

    single { Service().createService(HearthstoneApi::class.java) }

    single<HearthstoneRepository> { HearthstoneRepositoryImpl(get()) }

    single<GetHearthsUseCase> { GetHearths(get()) }

    single { SetCardViewModel(get()) }

    single { AllCardsViewModel(get()) }

}