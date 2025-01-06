package com.rezalaki.foody.data.repository.foodDetail

import com.rezalaki.foody.data.api.ApiHandler
import com.rezalaki.foody.data.model.responses.FoodsInfo
import kotlinx.coroutines.flow.Flow


interface FoodInfoRepository {
    suspend fun loadFoodInfo(foodId: Int): Flow<ApiHandler<FoodsInfo>>
}