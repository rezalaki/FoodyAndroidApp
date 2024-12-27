package com.rezalaki.foody.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rezalaki.foody.data.api.ApiHandlerState
import com.rezalaki.foody.data.model.responses.FoodsResponse
import com.rezalaki.foody.data.repository.FoodsListRepository
import com.rezalaki.foody.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodsListRepository: FoodsListRepository,
    private val isNetworkAvailable: Boolean
) : BaseViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.postValue(HomeUiState.LoadFailed("Simple error in coroutine : ${throwable.message}"))
    }

    private val _uiState = MutableLiveData<HomeUiState>()
    val uiState = _uiState.asFlow().asLiveData()

    init {
        loadFoods()
    }

    fun loadFoods() = viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
        if (isNetworkAvailable.not()) {
            _uiState.postValue(HomeUiState.NoConnection)
            return@launch
        }

        foodsListRepository.loadFoodsList().collect {
            val ui = when (it.state) {
                ApiHandlerState.SUCCESS -> HomeUiState.LoadSuccess(it.data as FoodsResponse)
                ApiHandlerState.FAILED -> HomeUiState.LoadFailed(it.errorMessage!!)
                ApiHandlerState.LOADING -> HomeUiState.Loading
            }
            _uiState.postValue(ui)
        }
    }

}