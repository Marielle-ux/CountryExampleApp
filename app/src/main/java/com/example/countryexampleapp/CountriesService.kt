package com.example.countryexampleapp

import retrofit2.http.GET

interface CountriesService {
    companion object {
        const val COUNTRY_URL = "countries"
    }

    @GET(CountriesService.COUNTRY_URL)
    suspend fun getCountry(): CountriesResponse

}