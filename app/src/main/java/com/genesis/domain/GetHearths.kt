package com.genesis.domain

import com.genesis.data.HearthstoneRepository
import com.genesis.domain.model.Hearthstone

class GetHearths(
    private val hearthstoneRepository: HearthstoneRepository
) : GetHearthsUseCase {

    override suspend fun invokeInfo(): List<String> = try {
        hearthstoneRepository.getIfo()
    } catch (ex: Exception) {
        listOf()
    }

    override suspend fun invoke(infoClass: String): List<Hearthstone> = try {
        hearthstoneRepository.getHearthstone(infoClass)
    } catch (ex: Exception) {
        listOf()
    }
}

interface GetHearthsUseCase {
    suspend operator fun invoke(infoClass: String): List<Hearthstone>
    suspend fun invokeInfo(): List<String>
}