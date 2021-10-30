package com.project.vinilos.data.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Album (
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("cover") val cover:String,
    @SerializedName("description") val description:String,
    @SerializedName("genre") val genre:String,
    @SerializedName("recordLabel") val recordLabel:String,
    @SerializedName("releaseDate") val releaseDate:Timestamp
)