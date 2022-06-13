package com.genesis.domain

import com.genesis.data.MealRepository
import com.genesis.domain.model.Hearthstone

class GetHearths(
    private val mealRepository: MealRepository
) : GetHearthsUseCase {

    override suspend fun invokeInfo(): List<String> = try {
        mealRepository.getIfo()
    } catch (ex: Exception) {
        listOf()
    }

    override suspend fun invoke(infoClass : String): List<Hearthstone> = try {
        mealRepository.getHearthstone(infoClass)
    } catch (ex: Exception) {
        listOf()
    }
}

interface GetHearthsUseCase {
    suspend operator fun invoke(infoClass : String): List<Hearthstone>
    suspend fun invokeInfo(): List<String>
}