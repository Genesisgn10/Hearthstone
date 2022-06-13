package com.genesis.data

import com.genesis.data.api.MealApi
import com.genesis.data.model.toCategory
import com.genesis.data.model.toHearthstone
import com.genesis.domain.model.Category
import com.genesis.domain.model.Hearthstone
import com.genesis.network.Output
import com.genesis.network.parseResponse

class MealRepositoryImpl(
    private val service: MealApi
) : MealRepository {

    override suspend fun getCategories(): List<Category> {
        val result = service.getCategories().parseResponse()
        return when (result) {
            is Output.Success -> {
                val categoryResponseList = result.value.categories

                categoryResponseList.map {
                    it.toCategory()
                }
            }
            is Output.Failure -> throw GetCategoriesException()
        }
    }

    override suspend fun getIfo(): List<String> {
        val result = service.getInfo().parseResponse()
        return when (result) {
            is Output.Success -> {
                val infoResponseList = result.value
                infoResponseList.sets
            }

            is Output.Failure -> throw GetCategoriesException()
        }
    }

    override suspend fun getHearthstone(cardClass: String): List<Hearthstone> {
        val result = service.get(cardClass).parseResponse()
        return when (result) {
            is Output.Success -> {
                val hearthstoneResponseList = result.value
                hearthstoneResponseList.map {
                    it.toHearthstone()
                }
            }
            is Output.Failure -> {
                throw GetCategoriesException()
            }

        }
    }
}

interface MealRepository {
    suspend fun getHearthstone(cardClass: String): List<Hearthstone>
    suspend fun getCategories(): List<Category>
    suspend fun getIfo(): List<String>
}

class GetCategoriesException : Exception()