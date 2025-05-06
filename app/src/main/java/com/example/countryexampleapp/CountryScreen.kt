package com.example.countryexampleapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@Composable
fun CountryScreen(countryData: DataX) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = countryData.name)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Capital: ${countryData.capital}")
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(countryData.flag)
                    .decoderFactory(SvgDecoder.Factory())
                    .build()
            ),
            contentDescription = "Флаг ${countryData.name}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}
