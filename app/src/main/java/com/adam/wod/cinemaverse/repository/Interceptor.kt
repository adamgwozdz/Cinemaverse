package com.adam.wod.cinemaverse.repository

import com.adam.wod.cinemaverse.util.Keys
import okhttp3.Interceptor
import okhttp3.Response

class Interceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", "Bearer ${Keys.apiKey()}")
        return chain.proceed(requestBuilder.build())
    }
}