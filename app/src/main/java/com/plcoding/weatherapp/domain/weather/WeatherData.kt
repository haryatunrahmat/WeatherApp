package com.plcoding.weatherapp.domain.weather

import java.time.LocalDateTime

// Data class yang merepresentasikan informasi cuaca
data class WeatherData(
    val time: LocalDateTime,         // Waktu data cuaca diambil
    val temperatureCelsius: Double,  // Suhu dalam derajat Celsius
    val pressure: Double,            // Tekanan udara
    val windSpeed: Double,           // Kecepatan angin
    val humidity: Double,            // Kelembaban udara
    val weatherType: WeatherType      // Jenis cuaca (contoh: cerah, hujan)
)

