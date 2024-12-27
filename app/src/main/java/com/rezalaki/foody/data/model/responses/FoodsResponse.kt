package com.rezalaki.foody.data.model.responses

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class FoodsResponse(
	@field:SerializedName("number") val number: Int,
	@field:SerializedName("totalResults") val totalResults: Int,
	@field:SerializedName("offset") val offset: Int,
	@field:SerializedName("results") val results: List<FoodItem>
) : Parcelable

@Parcelize
data class FoodItem(
	@field:SerializedName("image") val image: String,
	@field:SerializedName("id") val id: Int,
	@field:SerializedName("title") val title: String,
	@field:SerializedName("imageType") val imageType: String
) : Parcelable
