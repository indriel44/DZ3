package com.example.dz3.objects

import com.google.gson.annotations.SerializedName

class Friend: java.io.Serializable {
    @SerializedName("image_url")
    var url = ""
    fun imageId() = url

    @SerializedName("id") var id=""
    fun Id()= id
}