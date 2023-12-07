package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Komponen Compose untuk menampilkan ramalan cuaca per jam
@Composable
fun WeatherForecast(
    state: WeatherState, // State yang berisi informasi cuaca
    modifier: Modifier = Modifier // Modifier untuk konfigurasi tata letak
) {
    // Mengambil data cuaca per jam untuk hari pertama dari state
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        // Komponen Column untuk menampilkan elemen-elemen tampilan secara vertikal
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Menampilkan label hari ("Today")
            Text(
                text = "Today",
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Komponen LazyRow untuk menyusun elemen-elemen tampilan secara horizontal
            LazyRow(content = {
                // Menampilkan data cuaca per jam menggunakan komponen HourlyWeatherDisplay
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}
