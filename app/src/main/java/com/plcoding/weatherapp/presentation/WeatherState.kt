package com.plcoding.weatherapp.presentation

import com.plcoding.weatherapp.domain.weather.WeatherInfo

// Kelas data untuk merepresentasikan state (keadaan) dalam tampilan cuaca
data class WeatherState(
    val weatherInfo: WeatherInfo? = null, // Informasi cuaca yang akan ditampilkan
    val isLoading: Boolean = false, // Menunjukkan apakah sedang dalam proses pengambilan data
    val error: String? = null // Pesan kesalahan, jika terjadi
)
