package com.example.neardroid.model

import com.google.gson.annotations.SerializedName

data class ListCoffeeResponse(

	@field:SerializedName("ListCoffeeResponse")
	val listCoffeeResponse: List<ListCoffeeResponseItem?>? = null
)

data class ListCoffeeResponseItem(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("content")
	val content: String? = null
)
