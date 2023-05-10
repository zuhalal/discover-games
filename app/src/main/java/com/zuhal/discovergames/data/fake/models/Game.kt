package com.zuhal.discovergames.data.fake.models

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Game(
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("slug")
	val slug: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("background_image")
	val backgroundImage: String,

	@field:SerializedName("released")
	val released: String,

	@field:SerializedName("genres")
	val genres: List<Genre>,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("ratings_count")
	val ratingsCount: Int
) : Parcelable
