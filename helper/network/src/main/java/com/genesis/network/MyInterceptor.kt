package com.genesis.network

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("content-type", "application/json")
            .addHeader("X-RapidAPI-Key","aa0689cfc2mshbf494ba71946414p174556jsn74a00d82a9d2")
            .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}