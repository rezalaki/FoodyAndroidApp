package com.rezalaki.foody.data.api

import com.rezalaki.foody.data.model.responses.FoodsInfo
import com.rezalaki.foody.data.model.responses.FoodsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServices {
    @GET("complexSearch?diet=Vegan&number=20")
    suspend fun loadFoods(): Response<FoodsResponse>

    @GET("{foodId}/information")
    suspend fun loadFoodDetail(@Path("foodId") foodId: Int): Response<FoodsInfo>
}