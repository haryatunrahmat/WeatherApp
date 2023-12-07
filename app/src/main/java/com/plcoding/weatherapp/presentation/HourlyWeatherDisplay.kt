package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.plcoding.weatherapp.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

// Komponen Compose untuk menampilkan data cuaca per jam
@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData, // Data cuaca per jam
    modifier: Modifier = Modifier, // Modifier untuk konfigurasi tata letak
    textColor: Color = Color.White // Warna teks
) {
    // Memformat waktu menggunakan DateTimeFormatter
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }

    // Komponen Column untuk menampilkan data secara vertikal
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Teks menampilkan waktu
        Text(
            text = formattedTime,
            color = Color.LightGray
        )

        // Gambar menampilkan ikon cuaca
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )

        // Teks menampilkan suhu dalam derajat Celsius
        Text(
            text = "${weatherData.temperatureCelsius}°C",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}
