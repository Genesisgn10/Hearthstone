package com.genesis.data

import com.genesis.data.api.HearthstoneApi
import com.genesis.data.model.toHearthstone
import com.genesis.domain.model.Hearthstone
import com.genesis.network.Output
import com.genesis.network.parseResponse
import org.json.JSONException
import org.json.JSONObject


class HearthstoneRepositoryImpl(
    private val service: HearthstoneApi
) : HearthstoneRepository {

    override suspend fun getIfo(): List<String> {
        return when (val result = service.getInfo().parseResponse()) {
            is Output.Success -> {
                val infoResponseList = result.value
                infoResponseList.sets
            }

            is Output.Failure -> throw GetHearthstoneException()
        }
    }

    override suspend fun getHearthstone(cardClass: String): List<Hearthstone> {
        return when (val result = service.get(cardClass).parseResponse()) {
            is Output.Success -> {
                val hearthstoneResponseList = result.value
                hearthstoneResponseList.map {
                    it.toHearthstone()
                }
            }
            is Output.Failure -> {
                throw GetHearthstoneException()
            }

        }
    }
}

interface HearthstoneRepository {
    suspend fun getHearthstone(cardClass: String): List<Hearthstone>
    suspend fun getIfo(): List<String>
}

class GetHearthstoneException : Exception()