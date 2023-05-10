package com.zuhal.discovergames.data.fake.models

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

@Parcelize
data class Game(
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("slug")
	val slug: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("released")
	val released: String,

	@field:SerializedName("description")
	val description: String,

	@JsonProperty("background_image")
	@field:SerializedName("background_image")
	val backgroundImage: String? = null,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("genres")
	val genres: List<Genre>,
) : Parcelable
