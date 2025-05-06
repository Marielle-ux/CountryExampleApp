package com.example.countryexampleapp

import com.google.gson.annotations.SerializedName

data class CountryResponseSingle(
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: DataX,
    @SerializedName("statusCode")
    val statusCode: Int
)
