package com.rezalaki.foody.data.repository

import com.rezalaki.foody.data.api.ApiHandler
import com.rezalaki.foody.data.api.ApiServices
import com.rezalaki.foody.data.model.responses.FoodsInfo
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ActivityRetainedScoped
class FoodInfoRepository @Inject constructor(
    private val api: ApiServices
) {
    suspend fun loadFoodInfo(foodId: Int): Flow<ApiHandler<FoodsInfo>> =
        flow {
            emit( ApiHandler.loading() )

            val result = api.loadFoodDetail(foodId)
            if (result.isSuccessful) {

                emit( ApiHandler.success(result.body()!!) )

            } else {
                emit(
                    ApiHandler.error("API ERROR")
                )
            }

        }.catch {
            emit(
                ApiHandler.error("ERROR - ${it.message}")
            )
        }.flowOn(Dispatchers.IO)
}