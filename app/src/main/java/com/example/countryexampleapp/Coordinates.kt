package com.example.countryexampleapp


import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("latitude")
    val latitude: Double, // 48.0196
    @SerializedName("longitude")
    val longitude: Double // 66.9237
)