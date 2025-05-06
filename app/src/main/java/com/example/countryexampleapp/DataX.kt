package com.example.countryexampleapp


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("name")
    val name: String, // Afghanistan
    @SerializedName("capital")
    val capital: String, // Kabul
    @SerializedName("region")
    val region: String, // Asia
    @SerializedName("subregion")
    val subregion: String, // Southern Asia
    @SerializedName("population")
    val population: Int, // 38928341
    @SerializedName("area")
    val area: Double, // 346.36
    @SerializedName("coordinates")
    val coordinates: CoordinatesX,
    @SerializedName("borders")
    val borders: List<String>,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("currency")
    val currency: String, // Afghan Afghani (AFN)
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("flag")
    val flag: String // https://flagcdn.com/af.svg
)