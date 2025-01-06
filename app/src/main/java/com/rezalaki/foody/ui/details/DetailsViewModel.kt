package com.rezalaki.foody.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rezalaki.foody.data.api.ApiHandlerState
import com.rezalaki.foody.data.model.responses.FoodsInfo
import com.rezalaki.foody.data.repository.foodDetail.FoodInfoRepository
import com.rezalaki.foody.data.repository.foodDetail.FoodInfoRepositoryImpl
import com.rezalaki.foody.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val foodInfoRepository: FoodInfoRepository,
    private val isNetworkAvailable: Boolean
) : BaseViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.postValue(DetailsUiState.LoadFailed("Simple error in coroutine : ${throwable.message}"))
    }

    private val _uiState = MutableLiveData<DetailsUiState>()
    val uiState = _uiState.asFlow().asLiveData()

    fun loadDetails(foodId: Int) =
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            if (isNetworkAvailable.not()) {
                _uiState.postValue(DetailsUiState.NoConnection)
                return@launch
            }

            foodInfoRepository.loadFoodInfo(foodId).collect {
                val ui = when (it.state) {
                    ApiHandlerState.SUCCESS -> DetailsUiState.LoadSuccess(it.data as FoodsInfo)
                    ApiHandlerState.FAILED -> DetailsUiState.LoadFailed(it.errorMessage!!)
                    ApiHandlerState.LOADING -> DetailsUiState.Loading
                }
                _uiState.postValue(ui)
            }
        }

}