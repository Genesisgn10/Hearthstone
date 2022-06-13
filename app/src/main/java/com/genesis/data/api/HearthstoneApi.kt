package com.genesis.data.api

import com.genesis.data.model.HearthstoneResponse
import com.genesis.network.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HearthstoneApi {

    @GET("cards/sets/{classInfo}")
    suspend fun get(@Path("classInfo") classInfo: String): Response<List<HearthstoneResponse>>

    @GET("info")
    suspend fun getInfo(): Response<BaseResponse<String>>

}