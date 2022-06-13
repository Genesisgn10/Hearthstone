package com.genesis.domain

import com.genesis.data.MealRepository
import com.genesis.domain.model.Category

class GetCategories(
    private val mealRepository: MealRepository
) : GetCategoriesUseCase {

    override suspend fun invoke(): List<Category> = try {
        mealRepository.getCategories()
    } catch (ex: Exception) {
        listOf()
    }
}
interface GetCategoriesUseCase {
    suspend operator fun invoke(): List<Category>
}