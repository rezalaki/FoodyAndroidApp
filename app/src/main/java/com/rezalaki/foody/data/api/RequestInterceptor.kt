package com.rezalaki.foody.data.api

import android.util.Log
import com.google.gson.Gson
import com.rezalaki.foody.util.Constants
import okhttp3.Interceptor
import okhttp3.Response


class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val httpUrl = request.url.newBuilder()
            .addQueryParameter("apiKey", Constants.API_KEY)
            .build()
        val newRequest = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .url(httpUrl)
            .build()
        return chain.proceed(newRequest)
    }
}