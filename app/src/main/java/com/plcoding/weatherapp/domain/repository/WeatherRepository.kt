package com.plcoding.weatherapp.domain.repository

import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo

// Interface yang mendefinisikan kontrak untuk repository cuaca
interface WeatherRepository {
    // Fungsi untuk mendapatkan data cuaca berdasarkan koordinat lintang dan bujur
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}
