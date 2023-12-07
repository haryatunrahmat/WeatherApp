package com.plcoding.weatherapp.domain.util

// Kelas segel (sealed class) yang merepresentasikan status pemrosesan data.
sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    // Kelas yang mewakili status sukses, dengan data yang diberikan.
    class Success<T>(data: T?): Resource<T>(data)

    // Kelas yang mewakili status error, dengan pesan kesalahan dan opsional data yang diberikan.
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
