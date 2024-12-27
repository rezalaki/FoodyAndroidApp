package com.rezalaki.foody.ui.details

import com.rezalaki.foody.data.model.responses.FoodsInfo

sealed class DetailsUiState {

    object Loading: DetailsUiState()

    object NoConnection : DetailsUiState()

    data class LoadSuccess(val data: FoodsInfo): DetailsUiState()

    data class LoadFailed(val errorMessage: String) : DetailsUiState()
}