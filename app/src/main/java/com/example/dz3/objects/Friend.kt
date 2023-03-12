package com.example.dz3.objects

import com.google.gson.annotations.SerializedName
import kotlin.math.roundToInt

class Friend: java.io.Serializable {
    @SerializedName("image_url")
    var url = ""
    fun imageId() = url

    @SerializedName("name")
    var name=""
    fun name()= name

    @SerializedName("target_og")
    var steps: Double =0.01
    fun steps()= steps

    @SerializedName("abv")
    var place: Double =0.01
    fun place()= place

    @SerializedName("id")
    var id= 1
    fun id()= id


}