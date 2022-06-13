package com.genesis.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://www.themealdb.com/api/json/"
private const val BASE_URL2 = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
private const val API_VERSION = "v1/1/"

class Service {

    fun s(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .callTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(interceptor) //.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
            .addNetworkInterceptor { chain ->
                val request: Request =
                    chain.request().newBuilder()
                        .addHeader("content-type", "application/json")
                        .addHeader(
                            "X-RapidAPI-Key",
                            "aa0689cfc2mshbf494ba71946414p174556jsn74a00d82a9d2"
                        )
                        .addHeader(
                            "X-RapidAPI-Host",
                            "omgvamp-hearthstone-v1.p.rapidapi.com"
                        )// .addHeader(Constant.Header, authToken)
                        .build()
                chain.proceed(request)
            }.build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL2)
        .client(s())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }

    fun logInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}