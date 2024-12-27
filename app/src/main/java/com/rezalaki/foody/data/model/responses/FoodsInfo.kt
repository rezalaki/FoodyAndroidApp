package com.rezalaki.foody.data.model.responses

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class FoodsInfo(

    @field:SerializedName("instructions")
	val instructions: String? = null,

    @field:SerializedName("sustainable")
	val sustainable: Boolean? = null,

    @field:SerializedName("analyzedInstructions")
	val analyzedInstructions: List<AnalyzedInstructionsItem?>? = null,

    @field:SerializedName("glutenFree")
	val glutenFree: Boolean? = null,

    @field:SerializedName("veryPopular")
	val veryPopular: Boolean? = null,

    @field:SerializedName("healthScore")
	val healthScore: Float? = null,

    @field:SerializedName("title")
	val title: String? = null,

    @field:SerializedName("diets")
	val diets: List<String?>? = null,

    @field:SerializedName("aggregateLikes")
	val aggregateLikes: Float? = null,

    @field:SerializedName("creditsText")
	val creditsText: String? = null,

    @field:SerializedName("readyInMinutes")
	val readyInMinutes: Float? = null,

    @field:SerializedName("sourceUrl")
	val sourceUrl: String? = null,

    @field:SerializedName("dairyFree")
	val dairyFree: Boolean? = null,

    @field:SerializedName("servings")
	val servings: Float? = null,

    @field:SerializedName("vegetarian")
	val vegetarian: Boolean? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("imageType")
	val imageType: String? = null,

    @field:SerializedName("summary")
	val summary: String? = null,


    @field:SerializedName("image")
	val image: String? = null,

    @field:SerializedName("veryHealthy")
	val veryHealthy: Boolean? = null,

    @field:SerializedName("vegan")
	val vegan: Boolean? = null,

    @field:SerializedName("cheap")
	val cheap: Boolean? = null,

    @field:SerializedName("extendedIngredients")
	val extendedIngredients: List<ExtendedIngredientsItem?>? = null,

    @field:SerializedName("dishTypes")
	val dishTypes: List<String?>? = null,

    @field:SerializedName("gaps")
	val gaps: String? = null,


    @field:SerializedName("lowFodmap")
	val lowFodmap: Boolean? = null,

    @field:SerializedName("license")
	val license: String? = null,

    @field:SerializedName("weightWatcherSmartPoFloats")
	val weightWatcherSmartPoFloats: Float? = null,

    @field:SerializedName("occasions")
	val occasions: List<String?>? = null,

    @field:SerializedName("pricePerServing")
	val pricePerServing: Float? = null,

    @field:SerializedName("spoonacularScore")
	val spoonacularScore: Float? = null,

    @field:SerializedName("sourceName")
	val sourceName: String? = null,

    @field:SerializedName("originalId")
	val originalId: Int? = null,

    @field:SerializedName("spoonacularSourceUrl")
	val spoonacularSourceUrl: String? = null
) : Parcelable

@Parcelize
data class StepsItem(

    @field:SerializedName("number")
	val number: Float? = null,

    @field:SerializedName("ingredients")
	val ingredients: List<IngredientsItem?>? = null,

    @field:SerializedName("equipment")
	val equipment: List<EquipmentItem>? = null,

    @field:SerializedName("step")
	val step: String? = null
) : Parcelable

@Parcelize
data class EquipmentItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("localizedName")
	val localizedName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class Us(

	@field:SerializedName("amount")
	val amount: Float? = null,

	@field:SerializedName("unitShort")
	val unitShort: String? = null,

	@field:SerializedName("unitLong")
	val unitLong: String? = null
) : Parcelable

@Parcelize
data class IngredientsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("localizedName")
	val localizedName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class Measures(

    @field:SerializedName("metric")
	val metric: Metric? = null,

    @field:SerializedName("us")
	val us: Us? = null
) : Parcelable

@Parcelize
data class Metric(

	@field:SerializedName("amount")
	val amount: Float? = null,

	@field:SerializedName("unitShort")
	val unitShort: String? = null,

	@field:SerializedName("unitLong")
	val unitLong: String? = null
) : Parcelable

@Parcelize
data class ExtendedIngredientsItem(

    @field:SerializedName("originalName")
	val originalName: String? = null,

    @field:SerializedName("image")
	val image: String? = null,

    @field:SerializedName("amount")
	val amount: Float? = null,

    @field:SerializedName("unit")
	val unit: String? = null,

    @field:SerializedName("measures")
	val measures: Measures? = null,

    @field:SerializedName("nameClean")
	val nameClean: String? = null,

    @field:SerializedName("original")
	val original: String? = null,

    @field:SerializedName("meta")
	val meta: List<String?>? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("aisle")
	val aisle: String? = null,

    @field:SerializedName("consistency")
	val consistency: String? = null
) : Parcelable

@Parcelize
data class AnalyzedInstructionsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("steps")
	val steps: List<StepsItem?>? = null
) : Parcelable
