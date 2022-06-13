package com.genesis

import com.genesis.data.MealRepository
import com.genesis.data.MealRepositoryImpl
import com.genesis.data.api.MealApi
import com.genesis.domain.GetCategories
import com.genesis.domain.GetCategoriesUseCase
import com.genesis.domain.GetHearths
import com.genesis.domain.GetHearthsUseCase
import com.genesis.network.Service
import com.genesis.presenter.viewmodel.AllCardsViewModel
import com.genesis.presenter.viewmodel.MealViewModel
import org.koin.dsl.module

val mealServiceModule = module {

    single { Service().createService(MealApi::class.java) }

    single<MealRepository> { MealRepositoryImpl(get()) }

    single<GetHearthsUseCase> { GetHearths(get()) }

    single { MealViewModel(get()) }

    single { AllCardsViewModel(get()) }

    single<GetCategoriesUseCase> { GetCategories(get()) }

}