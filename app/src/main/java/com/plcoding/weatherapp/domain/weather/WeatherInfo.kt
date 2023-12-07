package com.plcoding.weatherapp.domain.weather

// Data class yang merepresentasikan informasi cuaca, terdiri dari data per hari dan data cuaca saat ini
data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>, // Map dari data cuaca per hari
    val currentWeatherData: WeatherData? // Data cuaca saat ini
)
