package com.rezalaki.foody.data.repository.foodList

import com.rezalaki.foody.data.api.ApiHandler
import com.rezalaki.foody.data.model.responses.FoodsResponse
import kotlinx.coroutines.flow.Flow


interface FoodListRepository {
    suspend fun loadFoodsList(): Flow<ApiHandler<FoodsResponse>>
}