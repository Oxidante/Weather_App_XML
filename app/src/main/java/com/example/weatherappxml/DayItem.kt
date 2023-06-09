package com.example.weatherappxml

import android.graphics.Region
import java.util.concurrent.locks.Condition

data class DayItem(
    val city: String,
    val region: String,
    val time: String,
    val condition: String,
    val imgUrl: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String
)