package com.plcoding.weatherapp.data.mappers

import com.plcoding.weatherapp.data.remote.WeatherDataDto
import com.plcoding.weatherapp.data.remote.WeatherDto
import com.plcoding.weatherapp.domain.weather.WeatherData
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import com.plcoding.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Kelas data private yang digunakan untuk menyimpan data cuaca bersama dengan indeksnya
private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

//untuk mengonversi objek WeatherDataDto menjadi Map dengan indeks sebagai kunci
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

// Untuk mengonversi objek WeatherDto menjadi objek WeatherInfo
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    // Mendapatkan peta data cuaca berdasarkan hari dari objek WeatherDataDto
    val weatherDataMap = weatherData.toWeatherDataMap()

    // Mendapatkan waktu saat ini
    val now = LocalDateTime.now()

    // Mencari data cuaca saat ini berdasarkan jam saat ini
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }

    // Membuat objek WeatherInfo dengan data cuaca per hari dan data cuaca saat ini
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}
