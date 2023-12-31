package com.example.dogslist

import com.google.gson.annotations.SerializedName

data class DogsResponse(
    @SerializedName("message") var images: List<String>,
    var status: Boolean
)
