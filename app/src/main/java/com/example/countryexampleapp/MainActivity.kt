package com.example.countryexampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryApp()
        }
    }
}

@Composable
fun CountryApp() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://countries-api-abhishek.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val services = retrofit.create(CountriesService::class.java)

    var allCountries by remember { mutableStateOf<List<DataX>>(emptyList()) }
    var countryDataResponse by remember { mutableStateOf<DataX?>(null) }
    var errorDataResponse by remember { mutableStateOf<String?>(null) }
    var inputCountryName by remember { mutableStateOf(TextFieldValue("")) }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    // Fetch countries on initial load
    LaunchedEffect(Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val response = services.getCountry()
                allCountries = response.data
            } catch (e: Exception) {
                errorDataResponse = e.localizedMessage
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = inputCountryName,
            onValueChange = { inputCountryName = it },
            label = { Text("Enter country name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button to search for a country
        Button(
            onClick = {
                isLoading = true
                errorDataResponse = null
                countryDataResponse = null
                coroutineScope.launch {
                    val foundCountry = allCountries.firstOrNull {
                        it.name.equals(inputCountryName.text.trim(), ignoreCase = true)
                    }
                    if (foundCountry != null) {
                        countryDataResponse = foundCountry
                    } else {
                        errorDataResponse = "Country not found"
                    }
                    isLoading = false
                }
            },
            enabled = inputCountryName.text.isNotBlank(),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Show")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Show country data or loading indicator
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (countryDataResponse != null) {
            CountryScreen(countryData = countryDataResponse!!)
        } else if (errorDataResponse != null) {
            Text("Error: $errorDataResponse")
        }
    }
}

