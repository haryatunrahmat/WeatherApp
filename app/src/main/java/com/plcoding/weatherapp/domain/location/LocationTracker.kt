package com.plcoding.weatherapp.domain.location

import android.location.Location

// Interface yang mendefinisikan kontrak untuk mendapatkan lokasi saat ini
interface LocationTracker {
    // Fungsi suspend untuk mendapatkan lokasi saat ini
    // Mengembalikan objek Location atau null jika tidak dapat diakses atau tidak tersedia
    suspend fun getCurrentLocation(): Location?
}
