package com.project.vinilos.data.model

import com.google.gson.annotations.SerializedName

data class Album (
    @SerializedName("name") val name:String,
    @SerializedName("artist") val artist:String,
    @SerializedName("cover") val cover:String,
    @SerializedName("description") val description:String,
    @SerializedName("genre") val genre:String,
    @SerializedName("recordLabel") val recordLabel:String,
    @SerializedName("releaseDate") val releaseDate:String
)