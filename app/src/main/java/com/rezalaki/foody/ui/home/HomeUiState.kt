package com.rezalaki.foody.ui.home

import com.rezalaki.foody.data.model.responses.FoodsResponse


sealed class HomeUiState {

    object Loading: HomeUiState()

    object NoConnection : HomeUiState()

    data class LoadSuccess(val data: FoodsResponse): HomeUiState()

    data class LoadFailed(val errorMessage: String) : HomeUiState()

}
