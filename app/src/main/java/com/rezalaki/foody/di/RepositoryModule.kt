package com.rezalaki.foody.di

import com.rezalaki.foody.data.api.ApiServices
import com.rezalaki.foody.data.repository.foodDetail.FoodInfoRepository
import com.rezalaki.foody.data.repository.foodDetail.FoodInfoRepositoryImpl
import com.rezalaki.foody.data.repository.foodList.FoodListRepository
import com.rezalaki.foody.data.repository.foodList.FoodsListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideFoodListRepository(apiServices: ApiServices): FoodListRepository = FoodsListRepositoryImpl(apiServices)

    @Provides
    @Singleton
    fun provideFoodDetailRepository(apiServices: ApiServices): FoodInfoRepository = FoodInfoRepositoryImpl(apiServices)

}