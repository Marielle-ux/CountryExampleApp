package com.example.countryexampleapp


import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("message")
    val message: String, // Successfully retrieved all countries
    @SerializedName("data")
    val `data`: List<DataX>,
    @SerializedName("statusCode")
    val statusCode: Int // 200
)