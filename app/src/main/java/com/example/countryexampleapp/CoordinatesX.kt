package com.example.countryexampleapp


import com.google.gson.annotations.SerializedName

data class CoordinatesX(
    @SerializedName("latitude")
    val latitude: Double, // 33.93911
    @SerializedName("longitude")
    val longitude: Double // 67.709953
)