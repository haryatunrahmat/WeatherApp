package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

// Komponen Compose untuk menampilkan data cuaca seperti tekanan, kelembaban, dan kecepatan angin
@Composable
fun WeatherDataDisplay(
    value: Int, // Nilai data cuaca
    unit: String, // Satuan data cuaca
    icon: ImageVector, // Ikon yang merepresentasikan jenis data cuaca
    modifier: Modifier = Modifier, // Modifier untuk konfigurasi tata letak
    textStyle: TextStyle = TextStyle(), // Gaya teks
    iconTint: Color = Color.White // Warna ikon
) {
    // Komponen Row untuk menyusun elemen-elemen tampilan secara horizontal
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Komponen Icon untuk menampilkan ikon data cuaca
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(25.dp)
        )
        // Spasi horizontal antara ikon dan teks
        Spacer(modifier = Modifier.width(4.dp))
        // Komponen Text untuk menampilkan nilai data cuaca dan satuan
        Text(
            text = "$value$unit",
            style = textStyle
        )
    }
}
