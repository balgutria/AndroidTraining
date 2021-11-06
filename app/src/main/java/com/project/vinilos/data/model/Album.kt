package com.project.vinilos.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.sql.Timestamp

data class Album (
    var id:Int,
    var name:String,
    var cover:String,
    var description:String,
    var genre:String,
    var recordLabel:String,
    var releaseDate:Timestamp
) : Serializable