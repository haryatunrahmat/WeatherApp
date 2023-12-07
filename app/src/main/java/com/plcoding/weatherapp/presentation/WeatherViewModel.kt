package com.plcoding.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.domain.location.LocationTracker
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel untuk mengelola data dan tampilan cuaca
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    // Mutable state untuk menyimpan dan mengelola keadaan (state) tampilan cuaca
    var state by mutableStateOf(WeatherState())
        private set

    // Fungsi untuk memuat informasi cuaca
    fun loadWeatherInfo() {
        viewModelScope.launch {
            // Mengganti keadaan menjadi sedang memuat
            state = state.copy(
                isLoading = true,
                error = null
            )
            // Mengecek dan mendapatkan lokasi saat ini
            locationTracker.getCurrentLocation()?.let { location ->
                // Mengambil data cuaca berdasarkan lokasi
                when(val result = repository.getWeatherData(location.latitude, location.longitude)) {
                    // Jika pengambilan data berhasil
                    is Resource.Success -> {
                        // Mengganti keadaan dengan data cuaca yang diterima
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    // Jika terjadi kesalahan dalam pengambilan data
                    is Resource.Error -> {
                        // Mengganti keadaan dengan pesan kesalahan
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                // Jika lokasi tidak dapat diperoleh
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}
